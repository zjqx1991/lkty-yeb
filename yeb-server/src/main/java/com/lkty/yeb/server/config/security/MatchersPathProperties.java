package com.lkty.yeb.server.config.security;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


/**
 * 放行路径
 */
@Data
@ConfigurationProperties(prefix = "lkty.security")
public class MatchersPathProperties {

    // 放行路径
    private List matchers;
}
