package com.example.concurrent.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * Semaphore测试(尝试获取一个许可，获取到就执行，获取不到就舍弃)
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/22 11:29
 */
@Slf4j
public class SemaphoreExample3 {

  private final static int threadCount = 200;

  public static void main(String[] args) throws InterruptedException {
    ExecutorService exec = Executors.newCachedThreadPool();

    final Semaphore semaphore = new Semaphore(3);

    for (int i = 0; i < threadCount; i++) {
      final int threadNum = i;
      exec.execute(()->{
        try {
          if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){
            test(threadNum);
            //释放许可
            semaphore.release();
          }
        } catch (InterruptedException e) {
          log.error("exception",e);
        }
      });
    }
    log.info("finsh");
    exec.shutdown();
  }

  private static void test(int threadNum) throws InterruptedException {
    log.info("{}",threadNum);
    Thread.sleep(1000);
  }
}
