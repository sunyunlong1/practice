package com.example.concurrent.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * Synchronized演示修饰代码块/修饰方法.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/19 12:00
 */
@Slf4j
public class SynchronizedExample1 {

  //修饰一个代码块
  public void test1(int j) {
    synchronized (this) {
      for (int i = 0; i < 10; i++) {
        log.info("test1 {}-{}", j, i);
      }
    }
  }

  public void test11(int j){
    synchronized (this) {
      for (int i = 0; i < 10; i++) {
        log.info("test1 {}-{}", j, i);
      }
    }
  }

  //修饰一个方法
  public synchronized void test2(int j) {
    for (int i = 0; i < 10; i++) {
      log.info("test2  {} - {}", j, i);
    }
  }

  public static void main(String[] args) {
    SynchronizedExample1 example1 = new SynchronizedExample1();
    SynchronizedExample1 example2 = new SynchronizedExample1();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> {
      example1.test1(1);
    });
    executorService.execute(() -> {
      example2.test11(2);
    });
  }
}
