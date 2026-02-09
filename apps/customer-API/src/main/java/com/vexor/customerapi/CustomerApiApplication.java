package com.vexor.customerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.vexor")
@EnableJpaRepositories(basePackages = "com.vexor")
@EntityScan(basePackages = "com.vexor")
public class CustomerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiApplication.class, args);

        System.out.println("Hola mundo, soy cliente");
    }
}
