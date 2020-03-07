package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * 应用servlet入口
 *
 * @author sunyunlong5
 * @version 1.0
 * @date 2018/11/20 11:59
 */
@ServletComponentScan
@SpringBootApplication
public class LoginApplication extends SpringBootServletInitializer {

  //更改springboot端口
  @Bean
  public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
    return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
      @Override
      public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(1010);
      }
    };
  }
  public static void main(String[] args) {
    SpringApplication.run(LoginApplication.class, args);
  }

//  //将spring boot项目部署在tomcat的配置
//  @Override
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//    builder.sources(LoginApplication.class);
//    return super.configure(builder);
//  }
}
