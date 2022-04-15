package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/14 18:35
 * @description : 内部类-创建内部类
 */
public class Parcel1 {
    class Contents {
        private int i = 11;

        public int getI() {
            return i;
        }
    }

    class Destination {
        private String lable;

        public Destination(String lable) {
            this.lable = lable;
        }

        public String getLable() {
            return lable;
        }
    }

    /*
    像使用其他类一样使用内部类
     */
    public void ship (String dest){
        Contents contents = new Contents();
        System.out.println(contents.getI());
        Destination destination = new Destination(dest);
        System.out.println(destination.getLable());
    }

    public static void main(String[] args) {
        Parcel1 p1 = new Parcel1();
        p1.ship("Hunan");
    }
}

