package com.example.demo;

import org.springframework.boot.tomcat.TomcatConnectorCustomizer; 
import org.springframework.boot.tomcat.servlet.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> maxLocaleCountCustomizer() {
        return factory -> factory.addConnectorCustomizers(
            (TomcatConnectorCustomizer) connector -> connector.setMaxLocaleCount(-1)
        );
    }
}