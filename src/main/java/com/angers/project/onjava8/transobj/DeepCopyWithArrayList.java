package com.angers.project.onjava8.transobj;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/30 08:50
 * @description : ArrayList 深拷贝
 */
class Int2 implements Cloneable {
    private int i;

    public Int2(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Int2{" +
                "i=" + i +
                '}';
    }

    @Override
    protected Int2 clone() {
        try {
            return (Int2)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void increment(){
        i ++;
    }
}

class Int3 extends Int2 {

    private int j;

    public Int3(int i) {
        super(i);
    }
}
public class DeepCopyWithArrayList {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = x.clone();
        x2.increment();
        System.out.println("x = " + x + " , x2 = " + x2);
        Int3 x3 = new Int3(7);
        x3 = (Int3) x3.clone();
        ArrayList<Int2> v =
                IntStream.range(0,10)
                        .mapToObj(Int2::new)
                        .collect(Collectors
                                .toCollection(ArrayList::new));
        System.out.println("v : " + v);
        ArrayList<Int2> v2 = (ArrayList<Int2>) v.clone();
        // 将克隆数组列表的每个元素都赋值为原列表各个对象的克隆对象
        IntStream.range(0,v.size())
                .forEach(
                        i -> v2.set(i,v.get(i).clone()));
        v2.forEach(Int2::increment);
        System.out.println("v2 : " + v2);
        System.out.println("v : " + v);
    }
}
