package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试并发.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/18 23:11
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

  @RequestMapping("/test")
  @ResponseBody
  public String test(){
    int i=1;
    System.out.println(i++);
    return "test";
  }
}
