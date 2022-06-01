package com.angers.project.onjava8.newio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author : liuanglin
 * @date : 2022/6/1 14:07
 * @description :
 */
public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer){
        while (buffer.hasRemaining()){
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }
    public static void main(String[] args) {
        char [] data = "existing".toCharArray();
        ByteBuffer buffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer charBuffer = buffer.asCharBuffer();
        charBuffer.put(data);
        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
    }
}
