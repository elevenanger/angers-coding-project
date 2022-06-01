package com.angers.project.onjava8.newio;

import java.nio.ByteBuffer;

/**
 * @author : liuanglin
 * @date : 2022/6/1 09:19
 * @description : 从 ByteBuffer 中读取不同展现形式的数据
 */
public class GetDataFromByteBuffer {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        /*
        ByteBuffer 分配后
        所分配的缓冲区所存储的值将自动归零
        使用 while 循环检查每一位是否都为 0
         */
        int i = 0;
        while(i ++ < bb.limit())
            if (bb.get() != 0)
                System.out.println("nonzero");
        System.out.println("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("char buffer");
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();
        bb.rewind();
        bb.asShortBuffer().put((short) 19930830);
        System.out.println(bb.getShort());
        bb.rewind();
        bb.asIntBuffer().put(19990808);
        System.out.println(bb.getInt());
        bb.rewind();
        bb.asLongBuffer().put(999999999999L);
        System.out.println(bb.getLong());
        bb.rewind();
        bb.asFloatBuffer().put(1024.22f);
        System.out.println(bb.getFloat());
        bb.rewind();
        bb.asDoubleBuffer().put(10241024.2233d);
        System.out.println(bb.getDouble());
        bb.rewind();
    }
}
