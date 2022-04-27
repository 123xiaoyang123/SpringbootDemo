package com.example.pojo.file;


import java.io.File;
import java.util.Scanner;

/*
 * 练习
 * 定义一个工具类,该类要求用户运行该程序时输入一个路径.该工具类将路径下的文件|文件夹的数量统计出来.
 * */
public class FileDemoTestOne {
    private static int countFile = 0;//统计文件的数量
    private static int countDri = 0;//统计文件夹的数量
    private static File file=null;//创建一个File对象

    public static void main(String[] args) {
        System.out.println("请输入一个地址:");
        file = new File(new Scanner(System.in).next());//将输入的地址指定给File
        if (file.exists()) {//判断该地址是否存在
            select();
        }else{
            rescan();
        }
    }

    /*
     * 地址不存在循环输入方法
     * */
    public static void rescan() {
        System.out.println("地址不存在!请重新输入:");
        file = new File(new Scanner(System.in).next());
        if (file.exists()) {
            select();
        }
        rescan();
    }

    /*
     * 查询输入地址下文件方法
     * */
    public static void select() {
        if (file.isDirectory()) {//判断是否为目录
            File[] files = file.listFiles();//列出File对象的所有子文件和路径,返回File数组
            for (File list : files) {
                if (list.isDirectory()) {
                    countDri++;
                    file = list;//将目录地址赋值给file对象
                    reselect();
                    continue;
                }
                countFile++;
            }
        } else if (file.isFile()) {//判断是否为文件
            countFile++;
        }
        System.out.println("该地址下文件的总数量为:     " + countFile);
        System.out.println("该地址下文件的总数量为:     " + countDri);
    }

    /*
     * 循环查询子目录下文件方法
     * */
    private static void reselect() {
        for (File list : file.listFiles()) {
            if (list.isDirectory()) {
                countDri++;
                file = list;
                reselect();
                continue;
            }
            countFile++;
            if (list.lastModified() == file.length() - 1) {//判断是否遍历到最后一位
                file = list.getParentFile();//返回此目录的上一个文件地址,赋值给file
            }
        }
    }
}
