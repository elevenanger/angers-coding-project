package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 09:49
 * @description : 内部类-在方法中定义内部类
 * 这种内部类称为本地内部类或者局部内部类
 */
public class MakingInnerClassWithinMethod {

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("hunan");
        destination.readLabel();
        /* output:
        PDestination hunan
         */
    }
}

class Parcel5 {
    public Destination destination(String s){
        /*
        在方法中定义内部类
        PDestination 是方法 destination 的一部分
        而不是 Parcel5 的一部分
        它不能在方法 destination 之外进行访问
        return new PDestination(s); 仅仅意味着 PDestination 向上转型为 Destination 接口对象的引用
        通过这种方法可以实现接口创建接口对象，但是对外隐藏具体的实现和访问权限
        除此以外，它和常规的类没有区别
         */
        final class PDestination implements Destination {
            private final String label;

            public PDestination(String label) {
                this.label = label;
            }
            String getLabel(){
                return label;
            }
            @Override
            public void readLabel() {
                System.out.println(getClass().getSimpleName() + " " + getLabel());
            }
        }
        return new PDestination(s);
    }
}
