package com.mawi.s3example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public OpenAPI defServiceApi() {

        return new OpenAPI().info(new Info()
                .title("someApp")
                .description("We make it")
        ).specVersion(SpecVersion.V31);
    }
}
