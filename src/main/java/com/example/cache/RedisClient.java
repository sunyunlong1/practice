package com.example.cache;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis客户端.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/22 19:06
 */
@Component
public class RedisClient {

  @Resource(name = "redisPool")
  private JedisPool jedisPool;

  public void set(String key, String value) throws Exception {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      jedis.auth("123456");
      jedis.set(key, value);
    } finally {
      if (jedis != null) {
        jedis.close();
      }
    }
  }

  public String get(String key) throws Exception {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      jedis.auth("123456");
      return jedis.get(key);
    } finally {
      if (jedis != null) {
        jedis.close();
      }
    }
  }
}
