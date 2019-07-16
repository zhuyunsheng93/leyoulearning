package com.leyou.userconsumeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class UserConsumeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserConsumeServiceApplication.class, args);
  }
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
  }
}
