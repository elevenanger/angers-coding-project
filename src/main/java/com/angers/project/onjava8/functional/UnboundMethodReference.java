package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 14:30
 * @description : 函数-未绑定方法引用
 * 未绑定方法：没有绑定对象的非 static 方法
 * 要使用未绑定方法，必须提供对象
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
        /*
        TransformX.trans() 方法签名为：
        String trans(X x);
        参数为 X 类型对象，返回值类型 String
        X::f 对应 X.f() 方法 String f()
        方法有一个隐式的参数 X 类型 this ，返回值类型为 String
        将未绑定的方法引用 x.f() 赋值给 TransformX.trans()
        通过 ts.trans(x) 调用未绑定方法 x::f
        传递一个 X 类型对象 x 给它
        Java 使用 x 对 X.f() 的第一个隐式的参数 this 赋值
        完成了方法的调用
        如果函数方法有多个参数，只需要遵循第一个参数为目标类型-this 即可
        从这里可以看出，函数式编程传递的是方法
        将方法引用 x.f() 传递给 TransformX.trans()
        区别于面向对象编程传递的是对象数据
         */
        TransformX ts = X::f;
        X x = new X();
        System.out.println(ts.trans(x));
        System.out.println(x.f());
    }
}

class X {
    String f(){
        return "X::f";
    }
}

interface makeString {
    String make();
}

interface TransformX {
    String trans(X x);
}