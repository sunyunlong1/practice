package com.example.concurrent.atomic;

import com.example.annoations.ThreadSafe;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 安全的并发模拟.
 * AtomicIntegerFieldUpdater
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/19 9:48
 */

@Slf4j
@ThreadSafe
public class AtomicExample5 {

  private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater
      .newUpdater(AtomicExample5.class, "count");

  @Getter
  public volatile int count = 100;


  public static void main(String[] args) {

    AtomicExample5 example5 = new AtomicExample5();

    if (updater.compareAndSet(example5, 100, 120)) {
      log.info("update success 1,{}", example5.getCount());
    }

    if (updater.compareAndSet(example5, 100, 120)) {
      log.info("update success 2,{}", example5.getCount());
    } else {
      log.info("update failed,{}", example5.getCount());
    }

  }
}
