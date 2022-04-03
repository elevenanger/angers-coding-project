package com.angers.project.onjava8.operator;

import java.util.Random;

public class MathOps {

    public static void main(String[] args) {
        Random random = new Random(47);

        int i,j,k;
        j = random.nextInt(100) + 1;
        System.out.println("j="+j);
        k = random.nextInt(100) + 1;
        System.out.println("k="+k);
        i = j + k;
        System.out.println("i = j+k = "+i);
        i = j - k;
        System.out.println("i = j-k = "+i);
        i = j * k;
        System.out.println("i = j*k = "+i);
        i = j * -k; // 一元正负号和数学上的正负号作用相同
        System.out.println("i = j*-k = "+i);
        i = j / k;
        System.out.println("i = j/k = "+i);
        i = j % k;
        System.out.println("i = j%k = "+i);

        float u,v,w;
        v = random.nextFloat();
        System.out.println(v);
        w = random.nextFloat();
        System.out.println(w);
        u = v + w;
        System.out.println("u = v + w =" +u);
        u = v - w;
        System.out.println("u = v - w =" +u);
        u = v * w;
        System.out.println("u = v * w =" +u);
        u = v / w;
        System.out.println("u = v / w =" +u);
        u = v % w;
        System.out.println("u = v % w =" +u);

    }
}
