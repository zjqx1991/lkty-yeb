package com.lkty.yeb.server.config.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JWTProperties.class)
public class JWTConfig {
}
