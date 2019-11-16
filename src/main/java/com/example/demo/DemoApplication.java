package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }


   /* @Bean
    public DataSource dataSource() {

        AbstractRoutingDataSource dataSource = new TenantAwareRoutingSource();

        Map<Object,Object> targetDataSources = new HashMap<>();

        targetDataSources.put("tenant1", tenantDataSource("tenant1"));
        targetDataSources.put("tenant2", tenantDataSource("tenant2"));


        dataSource.setTargetDataSources(targetDataSources);

        dataSource.afterPropertiesSet();

        return dataSource;
    }

    public DataSource tenantDataSource(String tenantName) {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);

        dataSource.setJdbcUrl( "jdbc:mysql://localhost:3306/"+tenantName+"?autoReconnect=true&useSSL=false");
        dataSource.setUsername( "root");
        dataSource.setPassword( "root");

        return dataSource;
    }


    private static Properties getDefaultProperties() {

        Properties defaultProperties = new Properties();

        // Set sane Spring Hibernate properties:
        defaultProperties.put("spring.datasource.url","jdbc:mysql://localhost:3306/multitenancy?autoReconnect=true&useSSL=false");
        defaultProperties.put("spring.datasource.driver-class-name","com.mysql.cj.jdbc.Driver");
        defaultProperties.put("spring.datasource.username","root");
        defaultProperties.put("spring.datasource.password","root");
        defaultProperties.put("spring.jpa.show-sql", "true");
        defaultProperties.put("spring.jpa.hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        defaultProperties.put("spring.datasource.initialize", "true");

        // Prevent JPA from trying to Auto Detect the Database:
        defaultProperties.put("spring.jpa.database", "mysql");

        // Prevent Hibernate from Automatic Changes to the DDL Schema:
        defaultProperties.put("spring.jpa.hibernate.ddl-auto", "none");

        return defaultProperties;
    }*/

}
