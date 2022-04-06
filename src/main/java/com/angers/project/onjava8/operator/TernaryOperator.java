package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/5 19:40
 * @description : 三元运算符，条件运算符 conditional operator
 */
public class TernaryOperator {

    /**
     * 三元运算符表达式
     * @apiNote 当你需要将一个变量设置为两个值中的一个时，使用三元运算符是非常有保证的
     * @param i 输入值
     * @return 条件运算值
     */
    static  int ternary(int i){
        return i < 10 ? i * 100 : i * 10;
    }

    /**
     * 标准的 if else 判断
     * @param i 输入值
     * @return 条件运算值
     */
    static int standardIfElse(int i){
        if (i < 10)
            return i * 100;
        else
            return i * 10;
    }

    public static void main(String[] args) {

        int i = 9;
        int j = 10;
        System.out.println(ternary(i));
        System.out.println(standardIfElse(i));
        System.out.println(ternary(j));
        System.out.println(standardIfElse(j));

    }
}
