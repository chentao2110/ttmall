package com;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@MapperScan({"com.ttmall.dao"})
@SpringBootApplication(scanBasePackages = "com.ttmall")


public class App 
{
    public static void main( String[] args )
    {


        SpringApplication.run(App.class,args);
    }
}
