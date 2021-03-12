package com.lkty.yeb.server.utils;


import com.lkty.yeb.common.constant.server.TokenConstant;
import com.lkty.yeb.server.config.security.JWTProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    @Autowired
    private JWTProperties jwtProperties;

    /**
     * 根据用户信息生成 token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, userDetails.getUsername());
        claims.put(TokenConstant.CLAIM_KEY_CREATE_DATE, new Date());

        return generateToken(claims);
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token) {
        String userName = null;
        try {
            Claims claims = getClaimsFormToken(token);
            userName = claims.getSubject();
        }
        catch (Exception e) {
            userName = null;
        }

        return userName;
    }

    /**
     * 判断token
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否可以被刷新
     * @param token
     * @return
     */
    public boolean isRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFormToken(token);
        claims.put(TokenConstant.CLAIM_KEY_CREATE_DATE, new Date());
        return generateToken(claims);
    }

    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token中获取过期日期
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }

    /**
     * 从token中获取荷载
     * @param token
     * @return
     */
    private Claims getClaimsFormToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (Exception e) {
            claims = null;
        }

        return claims;
    }

    /**
     * 根据荷载生成JWT Token
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, this.jwtProperties.getSecret())
                .compact();
    }

    /**
     * 生成 token 失效时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + this.jwtProperties.getExpiration() * 1000);
    }
}
