package com.example.concurrent.concurrent;

import com.example.annoations.NotThreadSafe;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * CopyOnWriteArraySet线程安全
 * 底层就是CopyOnWriteArraySet所以也适合读多写少的操作
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/21 20:17
 */
@Slf4j
@NotThreadSafe
public class CopyOnWriteArraySetExample {


  //请求总数
  public static int clinetTotal = 5000;

  //同时并发执行的线程数
  public static int threadTotal = 200;

  private static Set<Integer> set = new CopyOnWriteArraySet<>();

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
    log.info("size():{}",set.size());
  }

  public static void update(int i) {
      set.add(i);
  }
}
