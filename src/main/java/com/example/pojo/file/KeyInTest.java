package com.example.pojo.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 转换流
* */
public class KeyInTest {

    public static void main(String[] args) {
        try {
            System.out.println("请输入内容:");
            //将System.in对象转换为Reader对象
            InputStreamReader reader = new InputStreamReader(System.in);
            //将普通的Reader对象包装成BufferedReader
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            //采用循环来读取
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("exit")) {
                    System.exit(1);
                }
                //打印读取的内容
                System.out.println("输出内容为:  " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
