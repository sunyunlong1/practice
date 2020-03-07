package com.example.concurrent.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * CountDownLatch测试超过规定时间就不执行，可以在await方法中给定等待的时间
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/22 11:29
 */
@Slf4j
public class CountDownLatchExample2 {

  private final static int threadCount = 200;

  public static void main(String[] args) throws InterruptedException {
    ExecutorService exec = Executors.newCachedThreadPool();

    final CountDownLatch countDownLatch  = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      final int threadNum = i;

      exec.execute(()->{
        try {
          test(threadNum);
        } catch (Exception e) {
          log.error("exception",e);
        }finally {
          countDownLatch.countDown();
        }
      });
    }
    countDownLatch.await(10, TimeUnit.MILLISECONDS);
    log.info("finsh");
    exec.shutdown();
  }

  private static void test(int threadNum) throws InterruptedException {
    Thread.sleep(100);
    log.info("{}",threadNum);
  }
}
