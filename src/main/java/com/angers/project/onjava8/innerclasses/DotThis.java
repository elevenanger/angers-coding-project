package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 08:37
 * @description : 使用 this 关键字访问外部类对象
 */
public class DotThis {
    void f() {
        System.out.println(getClass().getSimpleName()+ ".f()");
    }
    public class Inner{
        public DotThis outer(){
            // OuterClass.this 获取外部类对象
            return DotThis.this;
            // 一个单独的 this 将会返回内部类对象
        }
    }
    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.inner();
        inner.outer().f();
    }
}


