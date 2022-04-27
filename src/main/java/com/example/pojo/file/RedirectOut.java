package com.example.pojo.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
* 重定向标准输入流
* */
public class RedirectOut {
    public static void main(String[] args) {
        try {
            //一次性创建PrintStream输出流
            PrintStream printStream=new PrintStream(new FileOutputStream("test.txt"));
            //将标准输出重定向到printStream输出流
            System.setOut(printStream);
            System.out.println("普通字符串");
            //向标准输出输出一个对象
            System.out.println(new RedirectOut());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
