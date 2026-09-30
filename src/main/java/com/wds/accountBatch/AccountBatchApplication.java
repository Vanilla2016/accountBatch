package com.wds.accountBatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class AccountBatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        SpringApplication.run(AccountBatchApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
          
    }
}
