package com.mashosoft.i18demo.config.openApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
            .group("I18N Demo")
            .pathsToMatch("/**")
            .addOpenApiMethodFilter( method -> method.isAnnotationPresent( Operation.class) )
            .build();
    }

    @Bean
    public OpenAPI apiDescription() {
        return new OpenAPI()
            .info(new Info().title("I18N demo")
                .description( "project to explain the i18N cases in spring boot and how to use it properly" )
                .version( "1.0" ));
    }
}
