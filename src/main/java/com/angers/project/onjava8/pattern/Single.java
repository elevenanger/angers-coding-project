package com.angers.project.onjava8.pattern;


/**
 * @author : liuanglin
 * @date : 2022/5/20 08:28
 * @description : 设计模式-单例-使用泛型实现单例设计模式
 */
@SuppressWarnings("unchecked")
public final class Single <T>{
    private static Object single;

    public Single(T val) {
        // 确保 single 仅会被赋值一次
        if (single != null){
            throw new RuntimeException("Attempt to reassign Single <"
            + val.getClass().getSimpleName() + ">");
        }
        single = val;
    }

    public T get(){
        return (T)single;
    }

    public static void main(String[] args) {
        Single<String> stringSingle = new Single<>("FirstString");
        System.out.println(stringSingle.get());
        try {
            Single<String> stringSingle2 = new Single<>("SecondString");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            Single<Integer> integerSingle = new Single<>(1);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyString {
    private String s;

    public MyString(String s) {
        this.s = s;
    }

    /**
     * 变更 MyString s 属性的值
     * @param s 变更值
     */
    public synchronized void change(String s){
        this.s = s;
    }

    @Override
    public synchronized String toString() {
        return "MyString{" +
                "s='" + s + '\'' +
                '}';
    }

    public static void main(String[] args) {
        /*
        使用单例模式
        单例对象是一个可变的对象
        不可以重复创建单例对象
        但是可以对现有的单例对象进行修改
        可变对象可能会产生竞争条件
        对修改方法加上 synchronized 关键字
         */
        Single<MyString> myStringSingle = new Single<>(new MyString("my string init"));
        System.out.println(myStringSingle.get());
        myStringSingle.get().change("my string modified");
        System.out.println(myStringSingle.get());
    }
}