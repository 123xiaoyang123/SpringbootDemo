package com.example.pojo.file;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


/*
 * 文件输出字节流
 * */
public class FileOutputStreamTest {

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;

        FileOutputStream fileOutputStream = null;

        try {
            //指定一个文件
            fileInputStream = new FileInputStream("E:\\com.demo\\SpringbootDemo\\src\\main\\resources\\static\\image\\小样.jpg");
            //创建一个newFile文本接收读取的数据
            fileOutputStream = new FileOutputStream("newImg.jpg");

            byte[] bytes = new byte[32];
            //读取的字节数
            int hasRead = 0;

            while ((hasRead = fileInputStream.read(bytes)) > 0) {
                //读取多少就写多少
                fileOutputStream.write(bytes, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();//关闭输入流
                fileOutputStream.close();//关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
