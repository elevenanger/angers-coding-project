package com.angers.project.corejava.inheritance;

import java.util.ArrayList;

public class EmployeeDB {

    /**
     * 为传入的数组新增一个 MasterStudent 对象
     * @param rawArrayList  raw 原始类型数组列表
     */
    public static void update(ArrayList rawArrayList){
        MasterStudent masterStudent = new MasterStudent();
        rawArrayList.add(masterStudent);
    }

    public static ArrayList find(String query){
        ArrayList <Employee> list = new ArrayList<>();
        return list;
    }

    public static void main(String [] args){
        /*
        可以不进行类型转换将类型化数组赋值给原始数组，但是这种调用是不安全的
        update 方法为传入的数组新增了一个 MasterStudent 对象，但是 employees 数组对象类型是 Employee
        获取这个对象时将会发生异常
        类似于泛型的原理
         */
        ArrayList<Employee> employees = new ArrayList<>(100);
        update(employees);

        /*
        与之相对的是，如果将一个原始数组赋值给一个类型化的数组则会有告警，未检查的赋值
         */
        ArrayList <Employee> employees1 = EmployeeDB.find("abcd");
        /*
         转换后，依然会报错，未检查的转换
         这个 Java 泛型的一种限制结果
         为了兼容性，编译器检查类型规则是否违反后，会将所有类型的数组列表转换成原始数组列表
         在运行中的程序中，所有的数组列表都是等价的，在 JVM 中，没有类型参数
         类型转换 (ArrayList) 和 (ArrayList<Employee>) 执行相同的检查
         */
        ArrayList <Employee> employees2 = (ArrayList<Employee>) EmployeeDB.find("abcd");

        //如果意识到这个问题不是很严重，可以使用 @SuppressWarnings("unchecked") 注解抑制编译器的警告
        @SuppressWarnings("unchecked") ArrayList <Employee> employees3 = EmployeeDB.find("abcd");

    }
}