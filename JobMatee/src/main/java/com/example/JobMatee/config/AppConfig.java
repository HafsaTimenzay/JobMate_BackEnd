package com.example.JobMatee.config;

import com.example.JobMatee.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${file.upload-dir}") // Define this property in application.properties
    private String uploadDir;

    @Bean
    public FileStorageService fileStorageService() {
        return new FileStorageService(uploadDir);
    }
}
