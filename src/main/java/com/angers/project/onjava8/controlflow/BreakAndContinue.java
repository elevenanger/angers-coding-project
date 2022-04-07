package com.angers.project.onjava8.controlflow;

/**
 * @author : liuanglin
 * @date : 2022/4/6 11:35
 * @description : break 退出整个循环，不在执行剩余的语句
 * continue 停止当前迭代剩余语句的执行，从循环语句起始开始继续执行剩余的循环
 */
public class BreakAndContinue {

    static void testContinue(String s){
        System.out.println("Continue test: ");
        for (char c: s.toCharArray()){
            if (c == 'c') continue;
            System.out.print(c + " ");
        }
        System.out.println();
    }

    static void testBreak(String s){
        System.out.println("Break test: ");
        for (char c: s.toCharArray()){
            if (c == 'c') break;
            System.out.print(c + " ");
        }
        System.out.println();
    }

    /**
     * 使用 break 来终止无限循环
     */
    static void testBreakWithWhile(){
        System.out.println("Break test with while : ");
        int i = 0;
        while (true){
            i++;
            if (i == 10) continue;
            if (i == 20) break;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        testContinue("three cats in the canteen.");
        testBreak("three cats in the canteen.");
        testBreakWithWhile();
    }
}
