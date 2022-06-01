package com.angers.project.onjava8.newio;

import java.nio.*;

/**
 * @author : liuanglin
 * @date : 2022/6/1 09:39
 * @description : 通过视图缓冲区读取字节缓冲区的数据
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        buffer.rewind();
        System.out.println("Byte Buffer ");
        while (buffer.hasRemaining())
            System.out.print(buffer.position() + "->" + buffer.get() + ", ");
        System.out.println();
        System.out.println("Char Buffer ");
        CharBuffer charBuffer = ((ByteBuffer)buffer.rewind()).asCharBuffer();
        while (charBuffer.hasRemaining())
            System.out.print(charBuffer.position() + "->" + charBuffer.get() + ", ");
        System.out.println();
        System.out.println("Float Buffer ");
        FloatBuffer floatBuffer= ((ByteBuffer)buffer.rewind()).asFloatBuffer();
        while (floatBuffer.hasRemaining())
            System.out.print(floatBuffer.position() + "->" + floatBuffer.get() + ", ");
        System.out.println();
        System.out.println("Int Buffer ");
        IntBuffer intBuffer  = ((ByteBuffer)buffer.rewind()).asIntBuffer();
        while (intBuffer.hasRemaining())
            System.out.print(intBuffer.position() + "->" + intBuffer.get() + ", ");
        System.out.println();
        System.out.println("Long Buffer ");
        LongBuffer longBuffer = ((ByteBuffer)buffer.rewind()).asLongBuffer();
        while (longBuffer.hasRemaining())
            System.out.print(longBuffer.position() + "->" + longBuffer.get() + ", ");
        System.out.println();
        System.out.println("Short Buffer ");
        ShortBuffer shortBuffer = ((ByteBuffer)buffer.rewind()).asShortBuffer();
        while (shortBuffer.hasRemaining())
            System.out.print(shortBuffer.position() + "->" + shortBuffer.get() + ", ");
        System.out.println();
        System.out.println("Double Buffer ");
        DoubleBuffer doubleBuffer = ((ByteBuffer)buffer.rewind()).asDoubleBuffer();
        while (doubleBuffer.hasRemaining())
            System.out.print(doubleBuffer.position() + "->" + doubleBuffer.get() + ", ");
        System.out.println();
    }
}
