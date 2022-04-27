package com.example.pojo.file;

import java.io.FileReader;

/*
* 输入字符流实例
* */
public class FileReaderTest {

    public static void main(String[] args) throws Exception{

        FileReader fileReader=new FileReader("E:\\com.demo\\SpringbootDemo\\src\\main\\java\\com\\example\\pojo\\file\\FileReaderTest.java");

        char[] chars=new char[32];

        int hasRead=0;

        while ((hasRead=fileReader.read(chars))>0){
            System.out.println(new String(chars,0,hasRead));
        }
        fileReader.close();
    }
}
