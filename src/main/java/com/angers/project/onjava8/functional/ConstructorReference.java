package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 15:04
 * @description : 函数-构造函数引用
 * 捕获一个构造函数的引用
 * 然后通过该引用调用此构造函数
 */
public class ConstructorReference {
    public static void main(String[] args) {
        /*
        noArgs.make()
        make1Arg.make()
        make2Args.make()
        方法签名分别与 Doggo 的构造函数方法签名相同
        使用 Doggo::new 构造函数分别对接口抽象函数进行赋值
        通过调用接口方法完成对构造函数的调用，构造 Doggo 对象
         */
        NoArgs noArgs = Doggo::new;
        System.out.println(noArgs.make());
        Make1Arg make1Arg = Doggo::new;
        System.out.println(make1Arg.make("1arg"));
        Make2Args make2Args = Doggo::new;
        System.out.println(make2Args.make("2args",10));
    }
}

class Doggo {
    String name;
    int age = -1 ;

    public Doggo() {
        name = "wha";
    }

    public Doggo(String name) {
        this.name = name;
    }

    public Doggo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Doggo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

interface NoArgs {
    Doggo make();
}

interface Make1Arg {
    Doggo make(String name);
}

interface Make2Args {
    Doggo make(String name,int age);
}