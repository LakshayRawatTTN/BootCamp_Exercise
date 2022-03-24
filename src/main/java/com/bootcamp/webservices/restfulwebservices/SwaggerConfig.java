package com.bootcamp.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    public static final Contact DEFAULT_CONTACT = new Contact("Lakshay Rawat",
            "https://github.com/LakshayRawatTTN", "lakshay.rawat@tothenew.com");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("My Api","New Api","2.0","",DEFAULT_CONTACT,
            "API 2.0","www.api.com", new ArrayList());


    @Bean
    public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
}


}
