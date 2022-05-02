package com.angers.project.onjava8.reflection.pets;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/2 11:11
 * @description : 反射-通用的类型计数器
 */
public class TypeCounter extends HashMap<Class<?>,Integer> {
    private Class<?> baseType;
    public TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }
    public void count(Object obj){
        Class<?> type = obj.getClass();
        /*
        isAssignableFrom() 方法判断能否被正常的赋值
         */
        if (!baseType.isAssignableFrom(type))
            throw new RuntimeException(
                    obj + " incorrect type : " + type +
                            " , should be type or subtype of " + baseType
                    );
        countClass(type);
    }
    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type,quantity == null?1:quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }
    @Override
    public String toString() {
        return "{ " + entrySet().stream()
                .map(pair ->
                        String.format("%s=%s",
                                pair.getKey().getSimpleName(),
                                pair.getValue())
                        )
                .collect(Collectors.joining(", ")) + " }";
    }
}
