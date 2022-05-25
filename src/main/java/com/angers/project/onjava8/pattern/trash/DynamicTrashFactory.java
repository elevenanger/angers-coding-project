package com.angers.project.onjava8.pattern.trash;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : liuanglin
 * @date : 2022/5/25 16:25
 * @description : 动态垃圾回收工厂类
 */
public class DynamicTrashFactory {
    // type-构造函数映射 map
    private Map<String, Constructor> constructorMap = new HashMap<>();
    // Trash 类所在的包名
    private String packageName;

    public DynamicTrashFactory(String packageName) {
        this.packageName = packageName;
    }
    @SuppressWarnings("unchecked")
    public <T extends Trash> T create(TrashInfo trashInfo){
        try {
            String typeName = "com.angers.project.onjava8.pattern." +
                packageName + "." + trashInfo.type;
            /*
            根据 TrashInfo 中的信息
            创建 Trash 实例
            computeIfAbsent() 方法检查一个 key(typeName) 在 map 中是否存在
            存在则获取 value
            不存在则尝试使用提供的函数执行结果作为 value
            value 为一具体 Trash 类型的构造函数
            .newInstance(trashInfo.data) 使用 trashInfo.data 构建 Trash 对象
             */
            return (T) constructorMap.computeIfAbsent(
                    /*
                    this::findConstructor 函数根据 typeName 获取构造函数
                     */
                    typeName,this::findConstructor)
                    .newInstance(trashInfo.data);
        } catch (InvocationTargetException |
                InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException("Cannot create Trash : " + trashInfo,e);
        }
    }

    /**
     * 根据 typeName 查找并返回构造函数
     * @param typeName Trash 类型 类的全限定名
     * @return Trash 构造函数
     */
    private Constructor findConstructor(String typeName){
        try {
            System.out.println("Loading " + typeName);
            return Class.forName(typeName)
                    .getConstructor(double.class);
        }catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(
                    "Trash(double) Constructor not found :" +
                            typeName, e);
        }
    }
}
