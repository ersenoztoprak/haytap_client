package com.haytap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(value = {"com.haytap"})
public class AppConfig {

    /*@Bean
    public InternalResourceViewResolver viewResolver() {
            InternalResourceViewResolver viewResolver 
                      = new InternalResourceViewResolver();
            viewResolver.setViewClass(JstlView.class);
            viewResolver.setPrefix("/pages/");
            viewResolver.setSuffix(".xhtml");
            return viewResolver;
    }*/
    
    @Bean(name = "messageSource")
    public ResourceBundleMessageSource messageSource()
    {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("messages");
        return resourceBundleMessageSource;
    }

    @Bean(name = "dataSource")
     public DriverManagerDataSource dataSource() {
         DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
         driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
         driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/haytap");
         driverManagerDataSource.setUsername("ersen");
         driverManagerDataSource.setPassword("123456");
         return driverManagerDataSource;
     }	
}