package com.example.concurrent.atomic;

import com.example.annoations.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;
import lombok.extern.slf4j.Slf4j;

/**
 * 安全的并发模拟.
 * AtomicReference
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/19 9:48
 */

@Slf4j
@ThreadSafe
public class AtomicExample4 {

  private static AtomicReference<Integer> count = new AtomicReference<>(0);

  public static void main(String[] args) {
    count.compareAndSet(0,2);
    count.compareAndSet(0,1);
    count.compareAndSet(1,3);
    count.compareAndSet(2,4);
    count.compareAndSet(3,5);
    log.info("count:{} ",count.get());

  }
}
