package com.example.imcsanscompte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ImcSansCompteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImcSansCompteApplication.class, args);
    }

}
