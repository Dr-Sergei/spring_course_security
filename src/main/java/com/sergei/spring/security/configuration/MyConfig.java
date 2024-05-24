package com.sergei.spring.security.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "com.sergei.spring.security")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    //adding routing for JSP in analogue to applicationContext.xml
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public ComboPooledDataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try{
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://172.17.0.3:3306/my_db");
            dataSource.setUser("root");
            dataSource.setPassword("admin");
        }catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
