package com.angers.project.onjava8.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/6 09:58
 * @description : 泛型-创建任意无参构造函数的类对象
 */
public class BasicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.getConstructor().newInstance();
        }catch (InvocationTargetException |
                InstantiationException |
                IllegalAccessException |
                NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 默认的 Supplier 方法
     */
    public static <T> Supplier<T> create(Class<T> type){
        return new BasicSupplier<>(type);
    }
}
