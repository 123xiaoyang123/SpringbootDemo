package com.example.pojo.file;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {

    public static void main(String[] args) throws Exception{

        FileInputStream inputStream=new FileInputStream(
                "E:\\com.demo\\SpringbootDemo\\src\\main\\java\\com\\example\\pojo\\file\\ReadFile.java");
        FileChannel channel=inputStream.getChannel();

        ByteBuffer buffer=ByteBuffer.allocate(256);

        while (channel.read(buffer)!=-1){

            buffer.flip();

            Charset charset=Charset.forName("GBK");

            CharsetDecoder decoder=charset.newDecoder();

            CharBuffer charBuffer=decoder.decode(buffer);

            System.out.println(charBuffer);

            buffer.clear();
        }
    }
}
