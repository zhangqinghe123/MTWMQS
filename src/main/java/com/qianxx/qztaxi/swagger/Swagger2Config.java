package com.qianxx.qztaxi.swagger;

/*
* 2015-11-21
* MySwaggerConfig.java
* author:Zack Chan
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.qianxx.qztaxi.webService.api"})
public class Swagger2Config {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();
    }

    /**
     * api具体信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "鼎骏出行API文档",
                "",
                "1.0",
                "https://www.djrentcar.com",
                "",
                "Create By 鼎骏出行",
                ""
        );
        return apiInfo;
    }
}

