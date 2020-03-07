package com.example.concurrent.publish;

import com.example.annoations.NotRecommend;
import com.example.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/20 11:05
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

  private int thisCanBeEscape = 0;

  public Escape() {
    new InnerClass();
  }

  private class InnerClass{

    public InnerClass() {
      log.info("{}",Escape.this.thisCanBeEscape);
    }
  }

  public static void main(String[] args) {
    new Escape();
  }
}
