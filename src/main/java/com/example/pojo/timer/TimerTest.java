package com.example.pojo.timer;

import org.bouncycastle.asn1.tsp.TimeStampResp;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {

        Timer timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("123");
            }
        } ,1000,2000);

    }


}
