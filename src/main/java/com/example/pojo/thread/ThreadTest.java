package com.example.pojo.thread;

public class ThreadTest {

    public static void main(String[] args) {

        parkingLot pl = new parkingLot();
        park p=new park(pl);
        drive d=new drive(pl);
        Thread t1=new Thread(p,"小轿车");
        Thread t2=new Thread(p,"自行车");
        Thread t3=new Thread(p,"大货车");
        Thread t4=new Thread(p,"摩托车");
        Thread t5=new Thread(d,"车主");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}

class parkingLot{//停车场作为一个类，其中包括各种方法以及车位的boolean[] 数组
    boolean[] sites = {true,true,true};//true表示可以停车（车位空）

    private boolean isFull(){//判断车位是否停满
        int e=0;
        for(int i=0;i<3;i++){
            if(!sites[i])
                e++;
        }
        return e==3;
    }

    private boolean isEmpty(){//判断车位是否全空
        int e=0;
        for (int i = 0; i < 3; i++) {
            if(sites[i])
                e++;
        }
        return e==3;
    }

    private int whichIsEmpty(){//判断哪个车位是空的，我认为也可以实现随机停车的效果，只需要使用Math类下的随机数方法
        for(int i=0;i<3;i++)
            if(sites[i])
                return i;
        return -1;   //这个return其实没用，但是如果没有的话会报错
    }

    private int whichIsFull(){//判断哪个是车位不是空的，我认为也可以实现随机开车的效果，只需要使用Math类下的随机数方法
        for(int i=0;i<3;i++)
            if(!sites[i])
                return i;
        return -1;  //这个return其实没用，但是如果没有的话会报错
    }

    public synchronized void park(){//停车的同步方法，先判断是否全满，若是，则线程等待
        if(isFull()){
            try {
                System.out.println("车满了！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            int num = whichIsEmpty();
            System.out.println(Thread.currentThread().getName() + "停在了" + num + "车位"+"++++++++");
            sites[num] = false;
            notifyAll();
        }
    }

    public synchronized void drive(){//开车的同步方法，先判断是否全空，若是，则线程等待
        if(isEmpty()){
            try {
                System.out.println("车位空了！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            int num = whichIsFull();
            System.out.println(Thread.currentThread().getName()+"开走了停在"+num+"的车位"+"--------");
            sites[num] = true;
            notifyAll();
        }
    }
}
class park implements Runnable{//停车的Runnable实现类
    private parkingLot pl;
    public park(parkingLot pl){
        this.pl = pl;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.currentThread().sleep(1000);//我搞的四个停车线程，为了方便观看效果，故暂停片刻
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pl.park();
        }
    }
}
class drive implements Runnable{//开车的Runnable实现类
    private parkingLot pl;
    public drive(parkingLot pl){
        this.pl = pl;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.currentThread().sleep(250);//四分之一的停车暂停时间，有更好的观看效果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pl.drive();
        }
    }
}