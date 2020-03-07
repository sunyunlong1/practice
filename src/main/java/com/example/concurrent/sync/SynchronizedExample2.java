package com.example.concurrent.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * Synchronized演示修饰一个类/修饰静态方法.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/19 12:00
 */
@Slf4j
public class SynchronizedExample2 {

  //修饰一个类
  public  void test1(int j) {
    synchronized (SynchronizedExample2.class) {
      for (int i = 0; i < 10; i++) {
        log.info("test1 {}-{}", j, i);
      }
    }
  }

  //修饰一个静态方法
  public static synchronized void test2(int j) {
    for (int i = 0; i < 10; i++) {
      log.info("test2  {} - {}", j, i);
    }
  }

  public static void main(String[] args) {
    SynchronizedExample2 example1 = new SynchronizedExample2();
    SynchronizedExample2 example2 = new SynchronizedExample2();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> {
      example1.test2(1);
    });
    executorService.execute(() -> {
      example2.test2(2);
    });
  }
}
