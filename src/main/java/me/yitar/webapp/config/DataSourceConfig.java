package me.yitar.webapp.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by Yitar on 2016/3/2.
 */
@Configuration
public class DataSourceConfig {
    @Primary //默认数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.druid")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }
}

