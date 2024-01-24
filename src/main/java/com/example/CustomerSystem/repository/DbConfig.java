package com.example.CustomerSystem.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * Configuration class.
 * @version 1.0
 */
@Configuration
public class DbConfig {

    /**
     * Create template with a dataSource.
     * @param dataSource
     * @return NamedParameterJdbcTemplate
     */
    @Bean
    public NamedParameterJdbcTemplate template(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
