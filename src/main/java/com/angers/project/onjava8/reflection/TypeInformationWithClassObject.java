package com.angers.project.onjava8.reflection;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/30 18:35
 * @description : 反射-使用 class 对象在运行时获取对象的类型信息
 */
interface HasBatteries{}
interface WaterProof{}
interface Shoots{}
class Toy {
    public Toy() {
        System.out.println("create no argument toy");
    }

    public Toy(int i) {}
}

class FancyToy extends Toy
        implements HasBatteries,WaterProof,Shoots{}

public class TypeInformationWithClassObject {
    static void printInfo(Class cc){
        System.out.println("ClassName: " + cc.getName() + "is interface? [ "
                + cc.isInterface() +" ]");
        System.out.println(
                "SimpleName: " + cc.getSimpleName()
        );
        System.out.println(
                "CanonicalName: " +cc.getCanonicalName()
        );
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.angers.project.onjava8.reflection.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        CommonUtils.printDivide("Print Interface");
        Arrays.stream(c.getInterfaces())
                .forEach(System.out::println);
        Class up = c.getSuperclass();
        Object o = null;
        try {
            // 使用类型 class 对象创建类型实例,调用对象类型的无参构造函数
            o = up.newInstance();
        }catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        printInfo(o.getClass());
    }
}