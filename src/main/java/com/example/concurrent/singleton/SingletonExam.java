package com.example.concurrent.singleton;

import com.example.annoations.NotThreadSafe;

/**
 * 单例模式(双重锁检测).
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/20 11:19
 */
@NotThreadSafe
public class SingletonExam {

  private SingletonExam (){

  }

  private  static SingletonExam instance = null;

  //1.这种方式也是线程不安全的，，因为JVM和CPU的优化，发生了指令重排

  //1.分配对象的内存空间
  //2.初始化对象
  //3.设置instance指向刚分配的内存

  //重排之后

  //1.分配对象的内存空间
  //3.设置instance指向刚分配的内存
  //2.初始化对象

  //此时假设有两个线程调用这个方法，(重排后的) A->1，B->3，然后B还没有执行第二步，那么A在判断instance是否为空的时候发现不为空，那么直接返回instance，
  //但是此时B还没有发布，所以这个时候调用就会有问题。所以是线程不安全的。

  //解决办法是加上volatile关键字  private volatile static SingletonExam instance = null;
  //为什么？因为涉及到了volatile的写操作。
  //volatile的应用场景，1.状态标示量 2.双重检测

  //静态工厂方法
  public static SingletonExam getInstance(){
    if(instance == null){
      synchronized (SingletonExam.class){
        if (instance == null){
          instance = new SingletonExam();
        }
      }
    }
    return instance;
  }

}
