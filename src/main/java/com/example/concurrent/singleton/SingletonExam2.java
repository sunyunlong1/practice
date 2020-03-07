package com.example.concurrent.singleton;

/**
 * 饿汉模式.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/20 11:46
 */

public class SingletonExam2 {

  private SingletonExam2() {

  }

  private static SingletonExam2 instance = null;

  static {
    instance = new SingletonExam2();
  }

  public static SingletonExam2 getInstance(){
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(getInstance().hashCode());
    System.out.println(getInstance().hashCode());
  }
}
