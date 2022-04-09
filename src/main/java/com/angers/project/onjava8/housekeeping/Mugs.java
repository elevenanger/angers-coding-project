package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/8 15:45
 * @description : 非 static 实例初始化
 */
public class Mugs {
    Mug mug1 ;
    Mug mug2 ;
    {
        /*
        实例初始化子句
        用于确保无论调用哪个构造函数构造对象都需要执行的操作
        实例初始化子句在构造函数之前执行
         */
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 initialized!" );
    }

    Mugs(){
        System.out.println("Mugs()");
    }

    Mugs(int marker){
        System.out.println("Mugs(" + marker +")");
    }

    public static void main(String[] args) {
        System.out.println("Mugs.main()");
        new Mugs();
        new Mugs(1);
        /*
        output:
        Mugs.main()
        Mug(1)
        Mug(2)
        mug1 & mug2 initialized!
        Mugs()
        Mug(1)
        Mug(2)
        mug1 & mug2 initialized!
        Mugs(1)
         */
    }
}

class Mug {
    Mug (int marker) {
        System.out.println("Mug(" + marker +")");
    }
}
