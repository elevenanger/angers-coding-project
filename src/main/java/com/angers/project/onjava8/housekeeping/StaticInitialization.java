package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 15:46
 * @description : static 数据初始化的过程
 */
public class StaticInitialization {

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
        static Bowl bowl2 = new Bowl(2);
        Table(){
            System.out.println("Table()");
            bowl2.f1(1);
        }
    }

}
