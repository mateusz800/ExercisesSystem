package com.example.core.domain.configuration;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/*
@Configuration
public class DbConfig {


    @Bean
    public DataSource getDataSource() throws URISyntaxException {

        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() ;//+ "?sslmode=require";

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }


}
 */

