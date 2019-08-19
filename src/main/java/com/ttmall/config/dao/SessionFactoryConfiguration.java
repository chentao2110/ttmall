package com.ttmall.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiguration {
    @Value("${mybatis.mapper-locations}")
    private String mapperPath;
    @Value("${dao.entity}")
    private String typeAliasPackages ;

    @Autowired
    private DataSource dataSource;
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean createSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        //设置mapper扫描路径
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String searchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
        sessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(searchPath));
        //设置数据源
        sessionFactoryBean.setDataSource(dataSource);
        //设置实体类
        sessionFactoryBean.setTypeAliasesPackage(typeAliasPackages);
        return sessionFactoryBean;
    }
}
