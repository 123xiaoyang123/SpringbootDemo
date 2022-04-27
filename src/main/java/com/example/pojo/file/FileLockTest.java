package com.example.pojo.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileLockTest {
    public static void main(String[] args) throws Exception {

        File file = new File("channel.txt");

        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();

        ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

        channel.position(file.length());

        channel.write(buffer);

        FileLock lock = channel.tryLock();

        Thread.sleep(10000);

        lock.release();
    }
}
