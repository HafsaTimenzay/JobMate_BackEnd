package com.example.JobMatee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // Allow the frontend to access backend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow HTTP methods
                .allowedHeaders("*")  // Allow any header
                .allowCredentials(true);  // Allow credentials (like cookies)
    }
}

