package com.example.concurrent.threadLocal;

/**
 * ThreadLocal存储登陆人信息,这个类一直整个项目中存在
 * 除非重新启动，ThreadLocal的信息才会更改
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/21 19:26
 */

public class RequestHolder {

  private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

  public static void add(Long id){
    requestHolder.set(id);
  }

  public static Long getId(){
    return requestHolder.get();
  }

  public static void remove(){
    requestHolder.remove();
  }
}
