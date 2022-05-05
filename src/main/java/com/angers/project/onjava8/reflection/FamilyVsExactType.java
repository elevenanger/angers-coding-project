package com.angers.project.onjava8.reflection;

/**
 * @author : liuanglin
 * @date : 2022/5/4 11:42
 * @description : 比较 instanceof 和 isInstance() 方法的区别
 */
public class FamilyVsExactType {
    static void test(Object x){
        System.out.println("Testing x of type : " +
                x.getClass());
        System.out.println("x instanceOf base : " +
                (x instanceof Base));
        System.out.println("x instanceof DerivedBase : " +
                (x instanceof DerivedBase));
        System.out.println("Base.isInstance(x) " +
                Base.class.isInstance(x));
        System.out.println("DerivedBase.isInstance(x) " +
                DerivedBase.class.isInstance(x));
        System.out.println("x.getClass() == Base.class " +
                (x.getClass() == Base.class));
        System.out.println("x.getClass() == DerivedBase.class " +
                (x.getClass() == DerivedBase.class));
        System.out.println("x.getClass().equals(Base.class) " +
                (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(DerivedBase.class) " +
                x.getClass().equals(DerivedBase.class));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new DerivedBase());
    }
}
class Base{}
class DerivedBase extends Base{}
