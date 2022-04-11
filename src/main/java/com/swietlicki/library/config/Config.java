package com.swietlicki.library.config;

import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2 )
                .select()
                .paths(PathSelectors. regex ( "^(?!/(error).*$).*$" ))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("LibraryService")
                .description("")
                .version("")
                .contact(new Contact("Krzysztof Swietlicki", "https://github.com/swietlik23",""))
                .build();
    }

}
