package com.lkty.yeb.common.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private final static String API_VERSION = "1.0";
    private final static String API_AUTHOR = "RavenWang";
    private final static String API_URL = "http://127.0.0.1:5000/doc.html";
    private final static String API_AUTHOR_EMAIL = "zjqx1991@163.com";
    private final static String API_DESCRIPTION = "YEB系统接口文档";
//    private final static String API_BASEPACKAGE = "com.lkty.yeb.api";
    private final static String API_BASEPACKAGE = "com.lkty.yeb";
    private final static String API_AUTHORIZATION = "Authorization";
    private final static String API_HEADER = "Header";

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(API_BASEPACKAGE))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes())
                ;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(API_DESCRIPTION)
                .description(API_DESCRIPTION)
                .contact(new Contact(API_AUTHOR, API_URL, API_AUTHOR_EMAIL))
                .version(API_VERSION)
                .build();
    }

    private List<ApiKey> securitySchemes() {
        // 设置请求头信息
        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey(API_AUTHORIZATION, API_AUTHORIZATION, API_HEADER);
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts() {
        // 设置需要登录认证的路径
        ArrayList<SecurityContext> result = new ArrayList<>();
        result.add(this.getContextByPath("/api/*"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = authorizationScope;
        result.add(new SecurityReference(API_AUTHORIZATION, scopes));
        return result;
    }



}
