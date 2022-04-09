package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 15:46
 * @description : static 数据初始化的过程
 * static 不能修饰局部变量
 * static 可以用来修饰实例域
 * 对象初始化完成之前先初始化实例域
 */
public class StaticInitialization {

    static Table table = new Table();

    static CupBoard cupBoard = new CupBoard();

    Table table2 = new Table();

    // 即便不显示声明 static ，构造函数也是 static 方法
    StaticInitialization(){
        System.out.println("StaticInitialization done !");
    }

    public static void main(String[] args) {
        System.out.println("main creating new Cupboard()");
        new CupBoard();
        System.out.println("main creating new Cupboard()");
        new CupBoard();
        table.f2(1);
        cupBoard.f3(1);

        /*
        output:
        执行 StaticInitialization 的 main() 方法
        首先需要加载 StaticInitialization 类
        Java 解释器从 classpath 查找 StaticInitialization 类
        StaticInitialization.class 加载完成
        初始化 StaticInitialization.class 中的 static 域
        static 域初始化只会发生一次
        按照顺序，初始化 static 域 table ，创建 Table 对象
        第一次创建 Table 对象，首先初始化 static 域 bowl1 bowl2
        然后执行构造函数打印信息，调用 bowl2.f1(1);
        Table 对象创建完成
        初始化实例域 cupBoard，创建 CupBoard 对象
        首次创建 CupBoard 对象，首先初始化 static 域 bowl4 bowl5
        初始化完成后，初始化其它实例域 bowl3
        实例域初始化完成，调用构造函数，执行构造函数内语句，完成  CupBoard 对象初始化
        static 域初始化完成之后，开始执行 main 方法
        new CupBoard() 创建新的 CupBoard 对象
        非首次创建， static 域之前已经完成初始化操作
        只初始化非 static 域 bowl3
        调用 CupBoard 构造函数，完成对象的创建

        Bowl(1)
        Bowl(2)
        Table()
        f1(1)
        Bowl(4)
        Bowl(5)
        Bowl(3)
        Cupboard
        f1(2)
        main creating new Cupboard()
        Bowl(3)
        Cupboard
        f1(2)
        main creating new Cupboard()
        Bowl(3)
        Cupboard
        f1(2)
        f2(1)
        f3(1)
         */
    }
}

class Bowl {
    Bowl(int marker){
        System.out.println(" Bowl(" + marker + ")");
    }
    void f1(int marker){
        System.out.println(" f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);
    Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker) {
        System.out.println(" f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class CupBoard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    CupBoard(){
        System.out.println("Cupboard");
        bowl4.f1(2);
    }
    void f3(int marker) {
        System.out.println(" f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}
