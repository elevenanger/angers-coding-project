package com.angers.project.onjava8.newio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author : liuanglin
 * @date : 2022/6/1 09:32
 * @description : 使用 IntBuffer 操作 ByteBuffer 中的 int
 */
public class IntBufferManipulation {
    private static final int SIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.put(new int[] {1,2,3,4,5,6});
        System.out.println(intBuffer.get(2));
        intBuffer.put(2,100);
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            int i = intBuffer.get();
            System.out.println(i);
        }
    }
}
