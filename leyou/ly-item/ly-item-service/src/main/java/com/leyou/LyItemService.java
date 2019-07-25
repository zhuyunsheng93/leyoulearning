package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/25 17:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LyItemService {

  public static void main(String[] args) {
    SpringApplication.run(LyItemService.class,args);
  }
}
