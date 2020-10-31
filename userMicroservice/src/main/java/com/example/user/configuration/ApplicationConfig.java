package com.example.user.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

;

@Configuration
@ComponentScan(basePackages = {"com.example.user", "com.example.core.domain.service", "com.example.user.configuration.security"})
@EntityScan(basePackages = "com.example.core.domain.entity")
@EnableJpaRepositories(basePackages = "com.example.core.domain.repository")
@EnableTransactionManagement
public class ApplicationConfig {


}
