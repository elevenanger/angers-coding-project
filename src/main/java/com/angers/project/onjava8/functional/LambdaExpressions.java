package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 09:40
 * @description : 函数-lambda 表达式
 */
public class LambdaExpressions {
    /*
    lambda 表达式的基本语法：
    1、参数
    2、参数后面跟着箭头 -> 可以将其读作产生
    3、箭头后面的内容是方法体
     */
    // 只有一个参数，可以不用括号包围，直接声明参数
    static Body body = b -> b + "this is body";
    // 完整的做法是用括号包围参数，但是单个参数一般不这么做
    static Body body2 = (b) -> b + "more details";
    // 没有参数，必须用括号表示空的参数列表
    static Description description = () -> "short info";
    // 多个参数，使用括号包围参数列表
    static Multi multi = (head, d) -> head + d;
    /*
    上面的几种用法，方法体都只有一行
    表达式的结果将自动称为方法的返回值
    方法体只有一行的情况下可以省略 return 关键字
    如果需要多行来构成 lambda 表达式
    必须用大括号包围方法体代码块
    使用 return 关键字返回 lambda 表达式产生的返回值
     */
    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines()";
    } ;

    public static void main(String[] args) {
        System.out.println(body.detailed("Oh! "));
        System.out.println(body2.detailed("Body2! "));
        System.out.println(description.brief());
        System.out.println(multi.twoArg("Pi ",3.14));
        System.out.println(moreLines.brief());

        /* output:
        Oh! this is body
        Body2! more details
        short info
        Pi 3.14
        moreLines()
        from moreLines()
         */
    }
}

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head,Double d);
}