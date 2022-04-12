package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 10:35
 * @description : 继承的语法和属性
 */
class Cleanser {
    /*
    一般来说，为了实现继承
    将域定义为 private
    方法定义为 public
    因为默认的访问权限只有 package
    如果继承类和基类不在同一个 package ，则无法使用这些方法
     */
    private String s = "Cleanser";
    public void append(String a){
        s += a;
    }
    public void dilute(){
        append(" dilute()");
    }
    public void apply(){
        append(" apply()");
    }
    public void scrub(){
        append(" scrub()");
    }
    @Override
    public String toString() {
        return "Cleanser{" +
                "s='" + s + '\'' +
                '}';
    }
    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
    }
    /* output
    Cleanser{s='Cleanser dilute() apply() scrub()'}
     */
}

public class Detergent extends Cleanser{
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        // super 关键字调用基类的方法
        super.scrub();
    }
    /**
     * 在派生的类中添加基类没有的新方法
     */
    public void form(){
        append(" form()");
    }

    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        // 可以直接使用基类的方法
        detergent.dilute();
        detergent.scrub();
        detergent.form();
        detergent.apply();
        System.out.println(detergent);
        System.out.println("Testing base class.");
        Cleanser.main(args);
        /* output
        Cleanser{s='Cleanser dilute() Detergent.scrub() scrub() form() apply()'}
        Testing base class.
        Cleanser{s='Cleanser dilute() apply() scrub()'}
         */
    }
}
