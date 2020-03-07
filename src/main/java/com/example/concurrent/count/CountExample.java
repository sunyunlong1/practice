package com.example.concurrent.count;

import com.example.annoations.NotThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * 不安全的并发模拟.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/19 9:48
 */

@Slf4j
@NotThreadSafe
public class CountExample {

  //请求总数
  public static int clinetTotal = 5000;

  //同时并发执行的线程数
  public static int threadTotal = 200;

  public static int count = 0;

  public static void main(String[] args) throws Exception{
    ExecutorService executorService = Executors.newCachedThreadPool();
    final Semaphore semaphore = new Semaphore(threadTotal);
    final CountDownLatch countDownLatch = new CountDownLatch(clinetTotal);
    for (int i = 0; i < clinetTotal; i++) {
      executorService.execute(() -> {
        try {
          semaphore.acquire();
          add();
          semaphore.release();
        } catch (Exception e) {
          log.error("exception", e);
        }
        countDownLatch.countDown();
      });
    }

    countDownLatch.await();
    executorService.shutdown();
    log.info("count:"+count);
  }

  public static void add() {
    ++count;
  }
}
