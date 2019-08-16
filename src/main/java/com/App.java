package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "com.ttmall")
@RestController
@MapperScan("com.ttmall.dao")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
