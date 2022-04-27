package com.example.pojo.file;

import java.io.*;

public class InsertContent {

    public static void main(String[] args)  throws IOException {
        insert("E:\\com.demo\\SpringbootDemo\\src\\main\\java\\com\\example\\pojo\\file\\InsertContent.java",
                440,"System.out.println("+"123"+");\r\n");
    }

    public static void insert(String fileName,long pos,String insertContent) throws IOException{

      File tmp=File.createTempFile("tmp",null);

        tmp.deleteOnExit();

        RandomAccessFile raf=new RandomAccessFile(fileName,"rw");

        FileOutputStream tmpOut=new FileOutputStream(tmp);

        FileInputStream tmpIn=new FileInputStream(tmp);

        raf.seek(pos);

        byte[] bytes=new byte[1024];

        int hasRead=0;

        while ((hasRead=raf.read(bytes))>0){
            tmpOut.write(bytes,0,hasRead);
        }

        raf.seek(pos);
        raf.write(insertContent.getBytes());

        while ((hasRead= tmpIn.read(bytes))>0){
            raf.write(bytes,0,hasRead);
        }

    }
}
