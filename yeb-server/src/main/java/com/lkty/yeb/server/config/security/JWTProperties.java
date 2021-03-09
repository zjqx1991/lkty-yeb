package com.lkty.yeb.server.config.security;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "lkty.security.jwt")
public class JWTProperties {

    //JWT存储的请求头
    private String tokenHeader;
    //JWT加解密使用的密钥
    private String secret;
    //JWT的超时时间
    private Long expiration;
    //JWT 负载中拿到开头
    private String tokenHead;
}
