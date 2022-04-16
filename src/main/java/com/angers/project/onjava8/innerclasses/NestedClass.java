package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 14:56
 * @description : 内部类-嵌套类：声明为 static 的内部类
 */
public class NestedClass {
    public static void main(String[] args) {
        /*
        无需 Parcel11 对象
        使用常规获取 static 成员的语法即可调用 static 方法返回 static 内部类向上转型的接口对象
         */
        Destination destination = Parcel11.destination("hunan");
        destination.readLabel();
        Contents contents = Parcel11.contents();
        System.out.println(contents.value());
        /* output:
        StaticParcelDestination hunan
        93
         */
    }
}

class Parcel11 {
    private static class StaticParcelContents implements Contents {
        private int i = 93;
        @Override
        public int value() {
            return i;
        }
    }
    protected static class StaticParcelDestination implements Destination {
        private String label;

        public StaticParcelDestination(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public void readLabel() {
            System.out.println(getClass().getSimpleName() + " " + getLabel());
        }
        // static 内部类可以包含其它的 static 元素
        static int x = 10;
        static class AnotherLevel {
            public static void f() {}
            static int x = 10;
        }
    }
    public static Destination destination(String lable){
        return new StaticParcelDestination(lable);
    }
    public static Contents contents(){
        return new StaticParcelContents();
    }

}
