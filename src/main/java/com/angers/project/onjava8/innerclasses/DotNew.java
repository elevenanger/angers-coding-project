package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 08:46
 * @description : 使用 OuterClass.new InnerClass() 创建内部类对象
 * 需要先创建外部类的对象，使用外部类对象创建内部类对象
 * 除非已经有一个外部类对象，否则无法直接创建内部类对象
 * 因为内部类对象有一个对于所创建它的外部类对象隐式的引用
 */
public class DotNew {

    private int val = 10;

    public int getVal() {
        return val;
    }

    class Inner1 {
        void f(){
            System.out.println(getClass().getSimpleName() + ".f() " + DotNew.this.getVal());
        }
    }

    class Inner2{
        private String desc;
        public Inner2(String desc) {
            this.desc = desc;
        }

        void g() {
            System.out.println(getClass().getSimpleName() + ".g() " + DotNew.this.getVal());
        }

        @Override
        public String toString() {
            return "Inner2{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 创建外部类对象
        DotNew dotNew = new DotNew();
        // 使用外部类对象创建内部类对象
        DotNew.Inner1 inner1 = dotNew.new Inner1();
        inner1.f();
        DotNew.Inner2 inner2 = dotNew.new Inner2("DotNew.Inner2");
        inner2.g();
        System.out.println(inner2.toString());
        DotNew.Inner2 anotherInner2 = dotNew.new Inner2("another inner2");
        anotherInner2.g();
        System.out.println(anotherInner2.toString());
        /* output:
        Inner1.f() 10
        Inner2.g() 10
        Inner2{desc='DotNew.Inner2'}
        Inner2.g() 10
        Inner2{desc='another inner2'}
         */
    }
}
