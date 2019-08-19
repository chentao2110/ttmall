package com.ttmall.config.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.springframework.web.servlet.config.annotation.*;


@Configuration
//相当于<mvc:annotation-drive>
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurationSupport implements ApplicationContextAware {
    //spring容器
    private  ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 定义静态资源默认配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
        //tomcat路径替换
        //registry.addResourceHandler("/upload/**").addResourceLocations("file:/Users/baidu/work/image/upload/");
        super.addResourceHandlers(registry);

    }

    /**
     * 定义默认请求处理器
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 创建视图解析器
     * @return
     *//*
    @Bean("viewResolver")
    public ViewResolver createViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setApplicationContext(applicationContext);
        viewResolver.setCache(false);
        viewResolver.setPrefix("/WEB-INF/html");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }*/
    /**
     * 文件上传解析器
     * @return
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver createCommonsMultipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setMaxInMemorySize(20971520);
        return multipartResolver;
    }
}
