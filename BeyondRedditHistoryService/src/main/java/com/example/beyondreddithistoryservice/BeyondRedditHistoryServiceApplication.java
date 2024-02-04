package com.example.beyondreddithistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BeyondRedditHistoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeyondRedditHistoryServiceApplication.class, args);
    }

}
