package com.kennesaw.studentportal.configurations;
import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan("com.kennesaw.studentportal")
@EnableAutoConfiguration
@EnableSwagger2
public class SpringFoxConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public Docket api() {
        return new Docket( DocumentationType.SWAGGER_2 )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.any() )
                .paths( Predicates.not( PathSelectors.regex( "/error.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/env.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/health.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/heapdump.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/metrics.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/restart.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/autoconfig.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/beans.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/configprops.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/dump.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/flyway.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/info.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/mappings.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/trace.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/pause.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/refresh.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/resume.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/exceptions.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/auditevents*.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/loggers*.*" ) ) )
                .paths( Predicates.not( PathSelectors.regex( "/cloudfoundryapplication*.*" ) ) )
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title( "Kennesaw Student Portal" )
                .description( "Kennesaw Student Portal RESTful API Documentation" )
                .license( "MIT" )
                .contact( new Contact( "Kennesaw Student Portal", "https://github.com/kalyansagi/student-portal.git", "" ) )
                .licenseUrl( "git@github.com:kalyansagi/student-portal.git" )
                .build();
    }
}
