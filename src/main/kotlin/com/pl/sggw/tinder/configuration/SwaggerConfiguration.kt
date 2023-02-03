package com.pl.sggw.tinder.configuration

import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.InternalResourceViewResolver
import springfox.documentation.builders.RequestHandlerSelectors.basePackage
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType.SWAGGER_2
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
@Profile("!test")
class SwaggerConfiguration(private val buildProperties: BuildProperties) {

    @Bean
    fun api() = Docket(SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(basePackage("com.pl.sggw.tinder"))
        .build()

    @Bean
    fun defaultViewResolver(): InternalResourceViewResolver? {
        return InternalResourceViewResolver()
    }

    private fun apiInfo() = ApiInfo(
        "SGGW Tinder rest api",
        "Rest api for ${buildProperties.name}",
        buildProperties.version,
        "",
        Contact("SGGW", "sggw.edu.pl", ""),
        "",
        "",
        listOf()
    )
}

