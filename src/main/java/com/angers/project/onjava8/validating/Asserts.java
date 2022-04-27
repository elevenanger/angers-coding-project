package com.angers.project.onjava8.validating;

/**
 * @author : liuanglin
 * @date : 2022/4/26 10:42
 * @description : 验证-在代码中设置断言
 */
public class Asserts {
    static void f(){
        assert false:
                "Asserts.f() failed";
    }
    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        /*
        断言表达式
        assert boolean-expression;
        assert boolean-expression:information-expression;
         */
        assert false;
        assert false:
                "Asserts.main() goes wrong";
        f();
    }
}
