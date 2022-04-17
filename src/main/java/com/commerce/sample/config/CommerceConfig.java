package com.commerce.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class CommerceConfig {
    @Primary
    @Bean(name = "oracle")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource(){return DataSourceBuilder.create().build();}

}
