package com.jaon.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Gao
 * @date 2018/5/14 16:44
 */
@Configuration
@EnableSwagger2

public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jaon.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        //其余身份认证：https://www.cnblogs.com/exmyth/p/7183753.html
        return new ApiInfoBuilder()
                .title("Api标题-springboot利用swagger构建api文档")
                .description("Api描述-简单优雅的restfun风格，更多配置参阅：https://blog.csdn.net/forezp/article/details/71023536||" +
                        "https://blog.csdn.net/catoop/article/details/50668896||" +
                        "https://www.jianshu.com/p/8553f315b2c8||" +
                        "https://www.jianshu.com/p/be05aa96fd29")
                .termsOfServiceUrl("服务条款的Url")
                .contact(new Contact("高杰","https://github.com/JackJao","766056142@qq.com"))
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0")
                .build();
    }
}
