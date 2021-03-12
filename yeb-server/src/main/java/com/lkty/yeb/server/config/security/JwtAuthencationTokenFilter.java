package com.lkty.yeb.server.config.security;

import com.lkty.yeb.server.service.impl.UserDetailsServiceImpl;
import com.lkty.yeb.server.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 */
@Component
public class JwtAuthencationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JWTProperties jwtProperties;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.jwtProperties.getTokenHeader());
        // 存在token
        if (null != authHeader && authHeader.startsWith(this.jwtProperties.getTokenHead())) {
            String token = authHeader.substring(this.jwtProperties.getTokenHead().length());
            String username = this.jwtTokenUtil.getUserNameFromToken(token);
            // token存在用户名但是未登录
            if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
                // 登录
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                // 验证token是否有效，重新设置用户对象
                if (this.jwtTokenUtil.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }

        // 放行
        filterChain.doFilter(request, response);
    }

}
