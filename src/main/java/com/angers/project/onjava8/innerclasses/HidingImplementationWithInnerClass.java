package com.angers.project.onjava8.innerclasses;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/15 09:21
 * @description : 使用内部类隐藏实现细节
 */
public class HidingImplementationWithInnerClass {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4("hunan");
        Contents contents = parcel4.contents();
        contents.value();
        Destination destination = parcel4.destination();
        destination.readLabel();
        // PDestination 访问权限为 protected 具有包和继承类的访问权限
        Parcel4.PDestination pDestination = parcel4.new PDestination("Anhui");
        pDestination.readLabel();
        /*
        Parcel4.PContents pContents = parcel4.new PContents();
        无法创建直接创建该内部类对象
        因为内部类 PContents 访问权限为 private，只能被外部类访问
        类无法被 private 和 protected 关键字修饰，但是内部类可以
        使用内部类实现接口，对外隐藏了实现的细节
         */
        /* output
        PContents.value()
        PDestination hunan
        PDestination Anhui
         */
    }
}

class Parcel4 {
    String destination;

    public Parcel4(String destination) {
        this.destination = destination;
    }
    private class PContents implements Contents{
        Random random = new Random();
        private int i = random.nextInt();
        @Override
        public int value() {
            System.out.println(getClass().getSimpleName() + ".value()");
            return i;
        }
    }

    protected final class PDestination implements Destination {
        String label ;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public void readLabel() {
            System.out.println(getClass().getSimpleName() + " " + label);
        }
    }

    public String getDestination(){
        return destination;
    }

    public Contents contents(){
        return new PContents();
    }

    public Destination destination(){
        return new PDestination(getDestination());
    }
}
