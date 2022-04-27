package com.example.pojo.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {
    public static void main(String[] args) {

        try {

            Process p = Runtime.getRuntime().exec("java ReadStandard");

            PrintStream printStream = new PrintStream(p.getOutputStream());

            printStream.println("普通字符串");

            printStream.println(new WriteToProcess());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class ReadStandard {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            PrintStream ps = new PrintStream(new FileOutputStream("out.txt"));
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                ps.println("键盘输入的内容是:  " + sc.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
