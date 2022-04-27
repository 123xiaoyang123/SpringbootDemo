package com.example.pojo.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* 重定向标准输入流
* */
public class RedirectIn {

    public static void main(String[] args) {
        try {
            FileInputStream inputStream=new FileInputStream("E:\\com.demo\\SpringbootDemo\\src\\main\\java\\com\\example\\pojo\\file\\RedirectIn.java");
            //将标准输入重定向到inputStream输入流
            System.setIn(inputStream);
            Scanner scanner=new Scanner(System.in);
            //增加下面一行只把回车当作分隔符
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                //输出输入项
                System.out.println("键盘输入的内容是:  "+scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
