package com.lkty.yeb.server.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.result.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 未登录或者token失效访问接口时，自定义的返回结果
 */
@Component
public class AuthorizationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        R error = R.error(RavenCodeEnum.LOGIN_NOT.getCode(), RavenCodeEnum.LOGIN_NOT.getMessage());
        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }


}
