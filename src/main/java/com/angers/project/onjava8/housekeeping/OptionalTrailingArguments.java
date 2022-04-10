package com.angers.project.onjava8.housekeeping;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/9 11:03
 * @description : 使用变量参数列表定义可选参数
 */
public class OptionalTrailingArguments {

    /**
     * 必选和可选参数
     * @param required 必选参数
     * @param optionalString 可选参数
     */
    static void f(int required, String ... optionalString){
        System.out.println("required : " + required + " .");
        Arrays.stream(optionalString)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        // 变量参数列表可以为空，所以可选参数可传可不传
        f(1,"this","is","optional!");
        f(0);
        /* output
        required : 1 .
        this is optional!
        required : 0 .
         */
    }
}
