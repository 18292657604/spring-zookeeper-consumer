package com.musingtec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringZookeeperConsumerApplication {


    @Autowired
    public RestTemplate restTemplate;


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @GetMapping("/hello")
    public String add(){
        String result = restTemplate.getForEntity("http://spring-cloud-service/", String.class).getBody();
        return result;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringZookeeperConsumerApplication.class, args);
    }
}
