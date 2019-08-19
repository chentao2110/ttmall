package com.ttmall.config.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ttmall.dao")
public class DataSourceConfiguretion {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
    return dataSource;
    }

}
