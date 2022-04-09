package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/8 14:44
 * @description : 通过 static 语句，显式地声明 static 初始化代码
 */
public class ExplicitStatic {

    public static void main(String[] args) {
        System.out.println("ExplicitStatic.main()");
        Cpus.cup1.f(99);
        Cpus.cup1.f(999);
        /*
        第一次访问 Cpus.class 类时，对 static 域进行初始化:
        初始化如下：
        static Cup cup1 = null;
        static Cup cup2 = null;
        static Cup cup3 = new Cup(3);
        再执行 static 声明的代码
        static 初始化和代码只会执行一次

        output:
        ExplicitStatic.main()
        Cup(3)
        Cup(1)
        Cup(2)
        Cup(31)
        Cup.f(99)
        Cup.f(999)
         */
    }
}
class Cup {
    Cup(int marker){
        System.out.println("Cup(" + marker +")");
    }
    void f(int marker){
        System.out.println("Cup.f(" + marker +")");
    }
}

class Cpus {
    Cpus(){
        System.out.println("cups()");
    }
    static Cup cup1; // 外面的 static 域会先进行初始化，这时初始化的值为 null
    static Cup cup2;
    static Cup cup3 = new Cup(3); // 外面的 static 域会先进行初始化，这时初始化的值为 new Cup(3)
    static {
        /*
        使用 static 关键字声明代码片段
        对于 static 域进行赋值
         */
        cup1 = new Cup(1);
        cup2 = new Cup(2);
        cup3 = new Cup(31);
        // cup4 = new Cup(4); 只能对 static 域进行赋值操作
    }
}
