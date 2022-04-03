package com.angers.project.onjava8.object;

import java.util.Date;

public class HelloDate {

    public static void main(String[] args) {
        /*
        System 类不需要再额外导入是因为每个java文件都会默认导入 java.lang 包
        System 在 java.lang 包内

        public final static PrintStream out = null;
        out 方法是 static 方法，不需要 new System() 对象即可直接调用
         */
        System.out.println("Hello, it's:");
        System.out.println(new Date());
    }
}
