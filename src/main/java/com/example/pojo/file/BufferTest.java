package com.example.pojo.file;

import java.nio.CharBuffer;

public class BufferTest {

    public static void main(String[] args) {

        CharBuffer charBuffer=CharBuffer.allocate(8);

        System.out.println("capacity:  "+charBuffer.capacity());

        System.out.println("limit:  "+charBuffer.limit());

        System.out.println("position:   "+charBuffer.position());

        charBuffer.put('a');

        charBuffer.put('b');

        charBuffer.put('c');

        System.out.println("加入3个元素后,position= "+charBuffer.position());

        charBuffer.flip();

        System.out.println("调用flip()方法后,limit= "+charBuffer.limit());

        System.out.println("position= "+charBuffer.position());

        charBuffer.clear();

        System.out.println("取出第一个元素(position=0): "+charBuffer.get());

        System.out.println("取出一个元素后,position= "+charBuffer.position());

        charBuffer.clear();

        System.out.println("执行clear()后,limit= "+charBuffer.limit());

        System.out.println("执行clear()后,position= "+charBuffer.position());

        System.out.println("执行clear()后,缓冲区内容并没有清除: "+"第三个元素为: "+charBuffer.get(2));

        System.out.println("执行绝对读取后,position= "+charBuffer.position());

    }
}
