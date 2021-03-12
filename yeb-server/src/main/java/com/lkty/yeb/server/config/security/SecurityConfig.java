package com.lkty.yeb.server.config.security;

import com.lkty.yeb.server.service.impl.UserDetailsServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Security 配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthencationTokenFilter jwtAuthencationTokenFilter;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthorizationEntryPointHandler entryPointHandler;
    @Autowired
    private MatchersPathProperties matchersPathProperties;


    /**
     * 重写，让登录时使用我们自己重写的 UserDetailsService
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()  //使用JWT，不需要 csrf
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 不需要认证的请求url，和 configure(WebSecurity web)方法冲突
//                .antMatchers()
//                .permitAll()
                // 所有请求都需要认证
                .anyRequest()
                .authenticated()
                .and()
                // 禁止缓存
                .headers()
                .cacheControl();

        // 添加JWT 登录授权过滤器
        http.addFilterBefore(this.jwtAuthencationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(this.accessDeniedHandler)
                .authenticationEntryPoint(this.entryPointHandler);
    }

    /**
     * 设置放行的 url
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(this.getMatchers());
    }

    /**
     * List<String> 转 String[]
     */
    private String[] getMatchers() {
        List<String> list = this.matchersPathProperties.getMatchers();
        String[] matchers = new String[list.size()];
        list.toArray(matchers);
        return matchers;
    }
}
