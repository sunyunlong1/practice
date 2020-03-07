package com.example.concurrent.singleton;

import com.example.annoations.Recommend;
import com.example.annoations.ThreadSafe;

/**
 * 枚举单例模式.最安全
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/20 11:55
 */
@ThreadSafe
@Recommend
public class SingletonExam3 {

  private SingletonExam3(){

  }

  public static SingletonExam3 getInstance(){

    return Singleton.INSTANCE.getInstance();
  }

  private enum Singleton{
    INSTANCE;

    private SingletonExam3 singleton;

    Singleton(){
      singleton = new SingletonExam3();
    }

    public SingletonExam3 getInstance(){
      return singleton;
    }
  }

}
