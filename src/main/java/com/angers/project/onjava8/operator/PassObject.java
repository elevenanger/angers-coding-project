package com.angers.project.onjava8.operator;

public class PassObject {

    static void f (Letter y){
        y.c = 'z';
    }

    public static void main(String[] args) {
        /*
        一般情况下 f() 在方法的作用域内使用 Letter y 对象的拷贝
        但是，一旦参数传入的是对象的引用，就会直接作用于对象变量所引用的对象
         */
        Letter x = new Letter();
        x.c = 'a';
        System.out.println(x.c);
        f(x);
        System.out.println(x.c);
        // 可以使用 new 一个新的对象传入
        f(new Letter());
    }
}

class Letter {
    char c;
}
