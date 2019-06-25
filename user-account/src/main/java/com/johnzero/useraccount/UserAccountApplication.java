package com.johnzero.useraccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAccountApplication.class, args);
    }

}
