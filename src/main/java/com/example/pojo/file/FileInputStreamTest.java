package com.example.pojo.file;

import java.io.FileInputStream;
import java.io.IOException;
/*
*
* 输入字节流实例
* */
public class FileInputStreamTest {

    public static void main(String[] args) {
        //创建字节输入流
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:\\com.demo\\SpringbootDemo\\src\\main\\java\\com\\example\\pojo\\file\\FileInputStreamTest.java");
            //创建一个长度为1024的"竹筒"
            byte[] bytes = new byte[1024];
            //用于保存实际读取的字节数
            int hasRead = 0;
            //循环来重复"取水"过程
            while ((hasRead = fileInputStream.read(bytes)) > 0) {
                //取出"竹筒"中的字节,将字节数组换成字符串输入
                System.out.println(new String(bytes, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件输入流,放在finally块里更安全
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
