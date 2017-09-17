package com.pingkeke.rdf;

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
 * Swagger2 的配置类.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket webApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("DemoAPI接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pingkeke.rdf.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo使用Swagger2构建RESTful APIs")
                .description("用户服务")
                .contact(new Contact("Bobby", "http://petstore.swagger.io/v2/swagger.json", "pingkeke@163.com"))
                .version("1.0")
                .build();
    }
}
