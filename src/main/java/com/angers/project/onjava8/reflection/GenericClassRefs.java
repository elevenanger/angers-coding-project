package com.angers.project.onjava8.reflection;

/**
 * @author : liuanglin
 * @date : 2022/5/2 09:28
 * @description : 反射-泛型类
 */
public class GenericClassRefs {
    public static void main(String[] args) {
        // 使用类给 Class 对象赋值
        Class intClass = int.class;
        // Class 对象仍然可以使用其它的类的 class 对象进行赋值
        intClass = double.class;
        // 使用泛型限定 Class 对象
        Class<Integer> genericIntClass = int.class;
        /*
        genericIntClass 只能赋值给泛型声明的类型
        泛型声明是编译器强制进行类型检查
         */
        genericIntClass = Integer.class;

        /*
        使用通配符可以扩展泛型的限制
        ? 是通配符的标识，表示任意类型
        使用 ? 表示不是无意忽略了类型指定
        表明你是需要使用一个不指定类型的 Class 对象
        可以使用继承关系缩小限定范围
        在 Class 对象引用添加泛型的主要原因是为编译器提供类型检查，以便及早发现问题
         */
        Class<?> intClassWild = int.class;
        intClassWild = double.class;
        Class<? extends Number> numberClass = int.class;
        numberClass = double.class;
    }
}
