package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/14 18:40
 * @description : 返回内部类的引用
 */
public class Parcel2 {
    class Contents {
        private int i = 11;

        public int getI() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    /*
    定义方法，返回内部类引用
     */
    public Destination to (String s){
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }

    void ship(String dest){
        Contents contents = contents();
        Destination destination = to(dest);
        System.out.println(destination.getLabel());
    }

    public static void main(String[] args) {
        Parcel2 p2 = new Parcel2();
        p2.ship("shaoyang");
        Parcel2 another = new Parcel2();
        /*
        在除了外部类的非 static 方法进行内部类的实例化
        需要使用 OuterClassName.InnerClassName 格式
         */
        Parcel2.Destination destination = another.to("sunBeach");
        System.out.println(destination.getLabel());
        Parcel2.Contents contents = another.contents();
        System.out.println(contents.getI());
    }
}


