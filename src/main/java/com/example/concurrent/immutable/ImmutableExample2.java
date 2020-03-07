package com.example.concurrent.immutable;

import com.example.annoations.NotThreadSafe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * final类型.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/21 18:49
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample2 {


  private static Map<Integer, Integer> map = new HashMap<>();

  static {
    map.put(1, 2);
    map.put(3, 4);
    map.put(5, 6);
    map = Collections.unmodifiableMap(map);
  }

  public static void main(String[] args) {
    map.put(7,8);
    log.info("{}", map);
  }

}
