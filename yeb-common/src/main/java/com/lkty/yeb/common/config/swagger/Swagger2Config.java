package com.lkty.yeb.common.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private final static String API_VERSION = "1.0";
    private final static String API_AUTHOR = "RavenWang";
    private final static String API_URL = "http://123.57.102.7:8001/doc.html";
    private final static String API_AUTHOR_EMAIL = "zjqx1991@163.com";
    private final static String API_DESCRIPTION = "SaaS管理系统接口文档";

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(API_DESCRIPTION)
                .description(API_DESCRIPTION)
                .contact(new Contact(API_AUTHOR, API_URL, API_AUTHOR_EMAIL))
                .version(API_VERSION)
                .build();
    }

}
