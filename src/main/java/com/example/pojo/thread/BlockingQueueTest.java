package com.example.pojo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {

        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);

        new Producer("生产者01",bq).start();
        new Producer("生产者02",bq).start();
        new Producer("生产者03",bq).start();

        new Consumer("消费者01",bq).start();
    }
}

class Producer extends Thread {

    private BlockingQueue<String> blockingQueue;

    public Producer(String name,BlockingQueue<String> blockingQueue) {
        super(name);
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String[] strings = new String[]{"java", "mysql", "vue"};
        for (int i = 0; i < 1000000000; i++) {
            System.out.println(getName() + "\t生产者准备生产集合元素!!!");
            try {
                Thread.sleep(200);
                blockingQueue.put(strings[i % 3]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "\t生产完成 " + blockingQueue);
        }
    }
}

class Consumer extends Thread {
    private BlockingQueue<String> blockingQueue;

    public Consumer(String name,BlockingQueue<String> blockingQueue) {
        super(name);
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + "\t消费者准备接收集合元素!!!");
            try {
                Thread.sleep(200);
                blockingQueue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "\t消费完成: " + blockingQueue);
        }
    }
}