package com.angers.project.onjava8.annotations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/13 09:09
 * @description :注解-实现注解处理器
 */
public class UseCaseTracker {
    /**
     * UseCase 注解处理器
     * @param @useCases UseCase ID 列表
     * @param cl 可能包含 @UseCase 注解的类
     */
    public static void trackUseCase(List<Integer> useCases,Class<?> cl){
        // 因为 UseCase 的作用域为方法，使用反射的机制查找 cl 中的方法
        Arrays.stream(cl.getDeclaredMethods())
                // 匹配包含 UseCase 注解的方法
                .map(method -> method.getAnnotation(UseCase.class))
                // 提取注解中的数据，进行处理
                .forEach(useCase -> {
                    // 对于查找到的注解,打印注解 id 以及描述信息
                    System.out.println("Found Use Case : " + useCase.id() + " " + useCase.desc());
                    // 从 id 列表中去掉能匹配到的注解 id
                    useCases.remove(Integer.valueOf(useCase.id()));
                });
        // 对于未能匹配到的注解 id , 输出信息
        useCases.forEach(integer ->
                System.out.println("Missing use case " + integer));
    }

    public static void main(String[] args) {
        List<Integer> cases =
                IntStream.range(90,99)
                        .boxed()
                        .collect(Collectors.toList());
        trackUseCase(cases,PasswordUtil.class);
    }
}
