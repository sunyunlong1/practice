package com.example.concurrent.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * CyclicBarrier测试
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/22 12:12
 */
@Slf4j
public class CyclicBarrierExample {

  private static CyclicBarrier barrier = new CyclicBarrier(2);

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newCachedThreadPool();

    for (int i = 0; i < 2; i++) {
      final int threadNum = i;
      Thread.sleep(1000);
      executor.execute(()->{
        try {
          race(threadNum);
        } catch (Exception e) {
          log.info("exception",e);
        }
      });
    }
    executor.shutdown();
  }

  private static void race(int threadNum) throws Exception{
    Thread.sleep(1000);
    log.info("{} is ready",threadNum);
    barrier.await();
    log.info("{} continue",threadNum);
    barrier.await();
    log.info("{} is ready all",threadNum);
  }
}
