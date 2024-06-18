package com.pt.isep.labdsoft;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "CITO API", version = "2.0", description = "CITO Information"))
@SecurityScheme(name = "cito", scheme = "basic", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
public class LabdsoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabdsoftApplication.class, args);

    }

}
