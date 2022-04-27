package com.example.pojo.file;

import lombok.Data;

import java.io.File;
import java.util.Scanner;

/*
 * (练习)
 * 定义一个工具类,该类要求用户运行该程序时输入一个路径(地址).
 * 该工具类将该路径(地址)下(及其子目录下)的所有文件列出来.
 *
 */
@Data
public class FileDemoTest {
    //创建一个Scanner对象来输入一个地址
    private static Scanner scanner;
    //创建一个File对象来获取输入的地址
    private static File file;
    public static void main(String[] args) {
        System.out.println("请输入文件地址:");
        scanner = new Scanner(System.in);
        file = new File(scanner.next());
        if (file.exists()) {//判断该地址是否存在
            select();
        } else {
            sca();
        }
        scanner.close();
    }

    /*
     * 递归判断该地址是否存在
     * */
    public static void sca() {
        System.out.println("该地址不存在!!!请重新输入:");
        scanner = new Scanner(System.in);
        file = new File(scanner.next());
        if (file.exists()) {
            select();
        } else {
            sca();
        }
        scanner.close();
    }

    /*
     * 将该地址下(及其子目录下)的所有文件列出来.
     * */
    public static void select() {
        //判断该路径是否是目录
        if (file.isDirectory()) {
            for (File list : file.listFiles()) {//循环遍历File对象的地址,返回一个File数组
                if (list.isDirectory()) {
                    file = list;//将子目录的绝对地址赋值给file
                    System.out.println(list.getName() + "(目录):");//输出目录名
                    select();
                    continue;
                }
                System.out.println(list.getName());//输出文件名
            }
        } else {//判断该地址是否是文件
            System.out.println("=====该文件如下=====");
            System.out.println(file.getName());
        }
    }
}
