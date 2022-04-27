package com.example.pojo.url;

import com.example.utils.DownUtil;

public class MultiThreadDown {
    public static void main(String[] args) throws Exception {
        final DownUtil downUtil = new DownUtil(
"https://p1.ssl.qhimgs1.com/sdr/400__/t01f75c69e081245051.jpg",
                "demo.jpg",
                2);
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1) {
                System.out.println("已完成:\t" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
