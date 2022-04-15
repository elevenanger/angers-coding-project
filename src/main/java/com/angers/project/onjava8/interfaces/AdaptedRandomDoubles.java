package com.angers.project.onjava8.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @author : liuanglin
 * @date : 2022/4/14 15:36
 * @description : 接口-使用继承创建适配器
 */
public class AdaptedRandomDoubles implements RandomDoubles,Readable{
    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) return -1;
        String result  = Double.toString(next())+ " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        /*
        采用接口作为参数的方法
        可以适配任何实现该接口的类的对象
         */
        try (Scanner scanner = new Scanner(new AdaptedRandomDoubles(10))){
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        }
        /* output:
        0.7255033141733149
        0.5827445905374687
        0.4255601416129512
        0.2695193614140914
        0.18039330039977397
        0.38004434332755
        0.6746422790306202
        0.2412967656439552
        0.02793866668744216
        0.6870598964947727
         */
    }
}
