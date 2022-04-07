package com.angers.project.onjava8.controlflow;

/**
 * @author : liuanglin
 * @date : 2022/4/6 14:07
 * @description : 标签是一个标识符，后面跟着冒号 :
 * 在 Java 中使用标签的唯一原因是有嵌套循环并且必须中断或继续通过多个嵌套级别
 */
public class LabeledForAndWhile {

    static int i = 0;

    static int k = 0;

    static void printBranch(String desc){
        System.out.println(" i = " + i + " " + desc);
    }

    static void labeledFor(){
        i = 0;
        k = 0;
        System.out.println("LabeledForStart!!!");
        outer :
        for ( ; true ;){ // 无限 for 循环
            printBranch("outer start ...");
            inner :
            for ( ; i < 10 ; i++ ) {
                printBranch("inner start ... " );
                if ( i == 2 ) {
                    printBranch("continue");
                    continue ;
                }
                if ( i == 3 ) {
                    printBranch("break");
                    i ++ ;
                    break ;
                }
                if ( i == 7 ) {
                    printBranch("continue outer");
                    i ++;
                    continue outer;
                }
                if ( i == 8) {
                    printBranch("break outer");
                    break outer;
                }
                for ( ; k < 5 ; k++){
                    if ( k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }

    static void labeledWhile(){
        i = 0;
        System.out.println("labeled while start ...");
        outer :
        while (true) {
            printBranch("while inner start ...");
            while (true){
                i ++ ;
                printBranch("");
                if ( i ==1 ) {
                    printBranch("while continue");
                    continue;
                }
                if (i ==3 ) {
                    printBranch("while continue outer");
                    continue outer;
                }
                if (i == 5) {
                    printBranch("while break ");
                    break ;
                }
                if ( i == 7 ){
                    printBranch("while break outer");
                    break outer;
                }
            }
        }
    }

    public static void main(String[] args) {
        labeledFor();
        labeledWhile();
    }
}
