package com.example.concurrent.publish;

import com.example.annoations.NotThreadSafe;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * 发布对象线程不安全的方式.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/20 10:57
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

  private String[] states = {"a","b","c"};

  public String[] getStates() {
    return states;
  }

  public static void main(String[] args) {
    UnsafePublish unsafePublish = new UnsafePublish();

    log.info("{}", Arrays.toString(unsafePublish.getStates()));

    unsafePublish.getStates()[0] = "d";

    log.info("{}", Arrays.toString(unsafePublish.getStates()));

  }
}
