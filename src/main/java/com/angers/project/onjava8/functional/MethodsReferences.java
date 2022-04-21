package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 14:02
 * @description : 使用 lambda 表达式引用方法
 */
public class MethodsReferences {
    // 符合 Callable.call() 方法签名
    static void hello(String msg){
        System.out.println("Hello , " +msg);
    }
    static class Description {
        String about;

        public Description(String about) {
            this.about = about;
        }
        // 符合 Callable.call() 方法签名
        void help(String msg){
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        // 符合 Callable.call() 方法签名 static 内部类中的 static 方法
        static void assist(String msg){
            System.out.println("Helper " + msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        /*
        d::show 是 Describe d 对象方法的引用
        将其赋值给 Callable c
        Callable 只有 call() 方法,没有 show() 方法
        但是 Java 支持这样的赋值
        因为它们的方法签名是一致的
         */
        Callable c = d::show;
        // 通过调用 c.call() 方法来调用 show() 方法,因为 java 将 call() 映射为了 show()
        c.call("call()");
        c = MethodsReferences::hello; // static 方法也同样适用
        c.call("bob");
        c = new Description("what")::help;
        c.call("info");
        c = Helper::assist; // static 内部类的 static 方法也适用
        c.call("help!");
    }
}

/**
 * 单个方法的接口
 */
interface Callable {
    void call(String s);
}

class Describe {
    /**
     * show 方法的签名（参数类型和返回值类型） 符合 Callable.call() 方法签名
     * @param msg 信息
     */
    void show(String msg){
        System.out.println("show: " + msg);
    }
}

