//package com.example;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * Description:
// *
// * @author sunyunlong5
// * @version 1.0
// * @date 2018/11/22 17:46
// */
//@Configuration
//public class SessionConfiguration implements WebMvcConfigurer {
//
//  @Autowired
//  URLInterceptor urlInterceptor;
//
//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
//    registry
//        .addInterceptor(urlInterceptor)
//        .addPathPatterns("/**")
//        .excludePathPatterns("/checkLogin")
//        .excludePathPatterns("/exit");
//  }
//}
