package com.example.pojo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        //创建一个具有固定线程数为(6)的线程池
        ExecutorService es= Executors.newFixedThreadPool(6);
        //使用lambda表达式创建Runnable对象
        Runnable target=() ->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
        };
        //向线程池提交2个线程
        es.submit(target);
        es.submit(target);
        //关闭线程池
        es.shutdown();
    }
}
