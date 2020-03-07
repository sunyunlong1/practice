package com.example.concurrent.commonUnsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * Description.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/21 20:31
 */
@Slf4j
public class HashMapExample {

  //请求总数
  public static int clinetTotal = 5000;

  //同时并发执行的线程数
  public static int threadTotal = 200;

  private static Map<Integer,Integer> map = new HashMap<>();

  public static void main(String[] args) throws Exception{
    ExecutorService executorService = Executors.newCachedThreadPool();
    final Semaphore semaphore = new Semaphore(threadTotal);
    final CountDownLatch countDownLatch = new CountDownLatch(clinetTotal);
    for (int i = 0; i < clinetTotal; i++) {
      final int count = i;
      executorService.execute(() -> {
        try {
          semaphore.acquire();
          update(count);
          semaphore.release();
        } catch (Exception e) {
          log.error("exception", e);
        }
        countDownLatch.countDown();
      });
    }

    countDownLatch.await();
    executorService.shutdown();
    log.info("size:{}",map.size());
  }

  public static void update(int i) {
    map.put(i,i);
  }
}
