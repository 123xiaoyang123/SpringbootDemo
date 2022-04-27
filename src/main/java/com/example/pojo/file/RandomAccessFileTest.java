package com.example.pojo.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    public static void main(String[] args) {

        try {
            RandomAccessFile raf=new RandomAccessFile(
                    "E:\\com.demo\\SpringbootDemo\\src\\main\\java\\com\\example\\pojo\\file\\RandomAccessFileTest.java","r");

            System.out.println("RandomAccessFile的文件指针的初始位置:   "+raf.getFilePointer());

            raf.seek(200);

            byte[] bytes=new byte[1024];

            int hasRead=0;

            while ((hasRead=raf.read(bytes))>0){
                System.out.println(new String(bytes,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
