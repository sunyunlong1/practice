package com.example.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * redis配置文件.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/22 18:54
 */
@Configuration
public class RedisConfig {

  @Bean(name = "redisPool")
  public JedisPool jedisPool(@Value("${jedis.host}") String host,
      @Value("${jedis.port}") int port) {
      return new JedisPool(host,port);
  }
}
