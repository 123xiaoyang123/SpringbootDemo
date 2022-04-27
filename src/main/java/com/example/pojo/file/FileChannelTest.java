package com.example.pojo.file;

import org.bouncycastle.util.test.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

    public static void main(String[] args) {


        File file=new File(
                "E:\\com.demo\\SpringbootDemo\\src\\main\\java\\com\\example\\pojo\\file\\FileChannelTest.java");

        try {

            FileChannel inChannel=new FileInputStream(file).getChannel();

            FileChannel outChannel=new FileOutputStream("channel.txt").getChannel();

            MappedByteBuffer mappedByteBuffer=inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());

            Charset charset=Charset.forName("GBK");

            outChannel.write(mappedByteBuffer);

            mappedByteBuffer.clear();

            CharsetDecoder decoder=charset.newDecoder();

            CharBuffer charBuffer=decoder.decode(mappedByteBuffer);

            System.out.println(charBuffer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
