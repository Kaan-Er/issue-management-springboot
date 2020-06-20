package com.champ.issuemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;

//@Configuration //proje calıstıgında buradaki ayarlamalar spring tarafından devreye alınacaktır.

public class SwaggerConfig {

   /* ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Issue Management API Reference")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.champ"))
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }

    */
}
