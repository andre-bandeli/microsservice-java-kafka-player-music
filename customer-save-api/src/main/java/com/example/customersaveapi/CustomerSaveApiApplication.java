package com.example.customersaveapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;


/* spring boot application abstrai as configurações do spring.

*  EnableAsync by doc: Enables Spring's asynchronous method
*  execution capability, similar to functionality found in
*  Spring's <task:*> XML namespace.

 */
@SpringBootApplication
@EnableKafka
@EnableAsync
public class CustomerSaveApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerSaveApiApplication.class, args);
    }

}
