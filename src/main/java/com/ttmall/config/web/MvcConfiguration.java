package com.ttmall.config.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
//相当于<mvc:annotation-drive>
//@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
    /*@Bean
    public CookieSerializer httpSessionIdResolver() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        // 取消仅限同一站点设置
        cookieSerializer.setUseSecureCookie(false);
        cookieSerializer.setUseHttpOnlyCookie(false);
        return cookieSerializer;
    }*/
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/").setViewName("/index");
    }*/



    @Override
    public void addCorsMappings(CorsRegistry registry) {

       registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS").allowCredentials(true).maxAge(3600);

    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/logout","/index.html","/checkbyphone","/checkbyemail","/registerbyemail","/sendsms","/registerbyphone","/error","/getproductinfo");
    }



    /**
     * 定义默认请求处理器
     * @param configurer
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
    //tomcat路径替换
    //registry.addResourceHandler("/upload/**").addResourceLocations("file:/Users/baidu/work/image/upload/");
    super.addResourceHandlers(registry);

    }
    /**
     * 创建视图解析器
     * @return
     */
    /*@Bean("viewResolver")
    public ViewResolver createViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setCache(false);
        viewResolver.setPrefix("classpath:templates/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }*/
    /**
     * 文件上传解析器
     * @return
*/    /**@Bean("multipartResolver")
    public CommonsMultipartResolver createCommonsMultipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setMaxInMemorySize(20971520);
        return multipartResolver;
    }*/
}
