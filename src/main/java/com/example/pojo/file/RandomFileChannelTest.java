package com.example.pojo.file;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {

    public static void main(String[] args) throws Exception{

        File file=new File("channel.txt");

        RandomAccessFile raf=new RandomAccessFile(file,"rw");

        FileChannel fileChannel=raf.getChannel();

        ByteBuffer buffer=fileChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());

        fileChannel.position(file.length());

        fileChannel.write(buffer);
    }
}
