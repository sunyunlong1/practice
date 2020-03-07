package com.example.concurrent.commonUnsafe;

import com.example.annoations.NotThreadSafe;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * 线程不安全的类与写法.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/21 20:01
 */
@Slf4j
@NotThreadSafe
public class DateFormatExample {

  private static SimpleDateFormat simpleDateFormat =
      new SimpleDateFormat("yyyyMMdd");

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
          update();
          semaphore.release();
        } catch (Exception e) {
          log.error("exception", e);
        }
        countDownLatch.countDown();
      });
    }

    countDownLatch.await();
    executorService.shutdown();
  }

  public static void update() {
    try{
      simpleDateFormat.parse("20180208");
    }catch (Exception e){
      log.error("parse exception",e);
    }
  }
}
