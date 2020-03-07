package com.example;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @ClassName RedisWithReentrantLock
 * @Decription TODO
 * @Auther mac
 * @Date 2019-09-07 11:33
 * @Version 1.0
 **/
public class RedisWithReentrantLock {

    private static ThreadLocal<Map<String, Integer>> lockers = new ThreadLocal<>();

    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    private boolean _lock(String key) {
        return jedis.set(key, "", "nx", "ex", 5L) != null;
    }

    private void _unlock(String key) {
        jedis.del(key);
    }

    private Map<String, Integer> currentLockers() {
        Map<String, Integer> refs = lockers.get();
        if (refs != null) {
            return refs;
        }
        lockers.set(new HashMap<>());
        return lockers.get();
    }

    public boolean lock(String key) {
        Map<String, Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt != null) {
            refs.put(key, refCnt + 1);
            return true;
        }
        boolean ok = this._lock(key);
        if (!ok) {
            return false;
        }
        refs.put(key, 1);
        return true;
    }

    public boolean unlock(String key) {
        Map<String, Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt == null) {
            return false;
        }
        refCnt -= 1;
        if (refCnt > 0) {
            refs.put(key, refCnt);
        } else {
            refs.remove(key);
            this._unlock(key);
        }
        return true;
    }

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1");
//        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
//        System.out.println(redis.lock("codehole"));
//        System.out.println(redis.lock("codeholh"));
//        Map<String, Integer> stringIntegerMap = lockers.get();
//        Integer integer = stringIntegerMap.get("codehole");
//        Integer integer1 = stringIntegerMap.get("codeholh");
//        System.out.println(integer);
//        System.out.println(integer1);
//        System.out.println(redis.unlock("codehole"));
//        System.out.println(redis.unlock("codeholh"));

        Thread thread = new Thread(new A());
        Thread thread2 = new Thread(new A());
        thread.setName("A");
        thread.start();
        thread2.setName("B");
        thread2.start();
    }

    static class A implements Runnable {
        public A() {
        }

        @Override
        public void run() {
            Jedis jedis = new Jedis("127.0.0.1");
            RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
            System.out.println(redis.lock("codehole") + Thread.currentThread().getName());
            System.out.println(redis.lock("codehole") + Thread.currentThread().getName());
            System.out.println(redis.lock("codehole") + Thread.currentThread().getName());
            System.out.println(redis.lock("codehole") + Thread.currentThread().getName());
            System.out.println(redis.lock("codehole") + Thread.currentThread().getName());
            System.out.println(redis.unlock("codehole")+ Thread.currentThread().getName());

            Map<String, Integer> stringIntegerMap = lockers.get();
            Integer integer = stringIntegerMap.get("codehole");
            System.out.println(integer);
        }
    }

}
