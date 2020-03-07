package com.example.concurrent.atomic;

import com.example.annoations.ThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.extern.slf4j.Slf4j;

/**
 * 安全的并发模拟.
 * AtomicBoolean
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/19 9:48
 */

@Slf4j
@ThreadSafe
public class AtomicExample6 {

  private static AtomicBoolean isHappend = new AtomicBoolean(false);

  //请求总数
  public static int clinetTotal = 5000;

  //同时并发执行的线程数
  public static int threadTotal = 200;

  public static void main(String[] args) throws Exception{
    ExecutorService executorService = Executors.newCachedThreadPool();
    final Semaphore semaphore = new Semaphore(threadTotal);
    final CountDownLatch countDownLatch = new CountDownLatch(clinetTotal);
    for (int i = 0; i < clinetTotal; i++) {
      executorService.execute(() -> {
        try {
          semaphore.acquire();
          test();
          semaphore.release();
        } catch (Exception e) {
          log.error("exception", e);
        }
        countDownLatch.countDown();
      });
    }

    countDownLatch.await();
    executorService.shutdown();
    log.info("count:{}", isHappend.get());
  }

  private static void test(){
    if(isHappend.compareAndSet(false,true)){
      log.info("execute");
    }
  }
}
