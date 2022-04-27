package com.example.pojo.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream;
        {
            try {
                fileOutputStream = new FileOutputStream("newFile.txt");
                PrintStream printStream = new PrintStream(fileOutputStream);
                printStream.println("普通字符串");
                printStream.println(new PrintStreamTest());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
