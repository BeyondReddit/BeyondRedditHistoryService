package com.example.beyondreddithistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@EnableEurekaClient
@EnableFeignClients
public class BeyondRedditHistoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeyondRedditHistoryServiceApplication.class, args);
    }

}
