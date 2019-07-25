package com.leyou.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/15 11:13
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
  }

}
