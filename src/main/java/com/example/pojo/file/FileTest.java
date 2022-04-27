package com.example.pojo.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //以当前路径来创建一个File对象
        File file = new File(".");
        //直接获取文件名,输出一点
        System.out.println(file.getName());
        //获取相对路径的父路径可能出错,下面输出null
        System.out.println(file.getParent());
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        //当前路径下创建一个临时文件
        File tmpFile = File.createTempFile("list", ".txt", file);
        //指定JVM退出时删除该文件
        tmpFile.deleteOnExit();
        //以系统当前时间作为新文件来创建新进文件
        File timeFile = new File(System.currentTimeMillis() + "");
        System.out.println("对象是否存在" + timeFile.exists());
        //以指定的timeFile对象来创建一个文件
        timeFile.createNewFile();
        //以timeFile对象来创建一个目录,因为timeFile已经存在,所以下面方法发挥false,即无法创建改目录
        timeFile.mkdir();
        //使用list()方法列出当前路径的所有文件和路径
        String[] strings = file.list();
        System.out.println("=====当前路径下所有文件和路径如下=====");
        for (String str : strings) {
            System.out.println(str);
        }
        //listRoots静态方法列出所有磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("=====系统所有跟路径如下=====");
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
