package com.example.pojo.thread;
/*
* 后台线程(Daemon Thread)
* */
public class DaemonThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName()+"-"+i);
        }
    }

    public static void main(String[] args) {

        DaemonThread dt=new DaemonThread();
        //将此线程设置为后台线程(守护线程)
        dt.setDaemon(true);
        //启动后台线程
        dt.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"-"+i);
        }
    }
}
