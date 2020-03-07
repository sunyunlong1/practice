package com.example.concurrent.immutable;

import com.example.annoations.NotThreadSafe;
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
public class ImmutableExample {

  private final static Integer a = 1;
  private final static String b = "2";
  private final static Map<Integer, Integer> map = new HashMap<>();

  static {
    map.put(1, 2);
    map.put(3, 4);
    map.put(5, 6);
  }

  public static void main(String[] args) {
    // a = 2;
    // b = "3"
    //map = new HashMap<>();
    map.put(1, 3);
    log.info("{}", map);
  }

  private void test(final int a) {
    // a=1;
  }
}
