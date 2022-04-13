package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/12 18:12
 * @description : 在编译时确定直接对域的访问
 */
public class FieldAccess {
    public static void main(String[] args) {
        /*
        如果直接访问一个域
        这个域的访问在编译时便已经确定
        多态的动态绑定只是针对于方法
        当一个派生类对象向上转换为基类的引用
        Super sub
        所有域的访问在编译时解析，因此对于域的访问不是多态的
        在实际情况下会将域设置为 private
        这种情况一般不会发生
         */
        Super sub = new Sub();
        System.out.println("sup.field = " + sub.field + " sub.getField() = " +sub.getField());
        Sub sub1 = new Sub();
        System.out.println("sub1.field = " + sub1.field +
                " sub1.getField() " + sub1.getField() +
                " sub1.getSuperField() = " + sub1.getSuperField());
        /* output:
        sup.field = 0 sub.getField() = 1
        sub1.field = 1 sub1.getField() 1 sub1.getSuperField() = 0
         */
    }
}

class Super {
    public int field = 0;
    public int getField(){
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}
