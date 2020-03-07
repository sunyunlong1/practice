package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/22 19:11
 */
@Controller
@RequestMapping("/cache")
public class CacheController {

  @Autowired
  RedisClient redisClient;

  @RequestMapping("/set")
  @ResponseBody
  public String set(@RequestParam String key,@RequestParam String value) throws Exception {
      redisClient.set(key,value);
      return "SUCCESS";
  }

  @RequestMapping("/get")
  @ResponseBody
  public String get(@RequestParam String key) throws Exception {
      return redisClient.get(key);
  }
}
