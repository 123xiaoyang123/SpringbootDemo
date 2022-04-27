package com.example.pojo.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

public class TaskTest extends TimerTask {
    @Override
    public void run() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        System.out.println("当前时间为:   "+simpleDateFormat.format(new Date()));
    }

    public static void main(String[] args) {

        Timer timer=new Timer();

        TaskTest taskTest=new TaskTest();

        timer.schedule(taskTest,1000,2000);

        Calendar calendar=Calendar.getInstance();

        calendar.set(Calendar.MINUTE,30);

        timer.schedule(taskTest,calendar.getTime(),2000);

    }

}
