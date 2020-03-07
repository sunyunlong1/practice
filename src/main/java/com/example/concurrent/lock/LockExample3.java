package com.example.concurrent.lock;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lombok.extern.slf4j.Slf4j;

/**
 * 安全的并发模拟.
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/19 9:48
 */

@Slf4j
public class LockExample3 {

  private final Map<String,Data> map = new TreeMap<>();
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

  private final Lock readLock = lock.readLock();

  private final Lock writeLock = lock.writeLock();

  public Data get(String key){
    readLock.lock();
    try{
      return map.get(key);
    }finally {
      readLock.unlock();
    }
  }

  public Set<String> getAllKeys(){
    readLock.lock();
    try{
      return map.keySet();
    }finally {
      readLock.unlock();
    }
  }

  public Data put(String key,Data value){
      writeLock.lock();
    try{
      return map.put(key,value);
    }finally {
      readLock.unlock();
    }
  }

  class Data{

  }
}
