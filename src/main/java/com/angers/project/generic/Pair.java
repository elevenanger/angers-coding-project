package com.angers.project.generic;

import com.angers.project.inheritance.Employee;
import com.angers.project.inheritance.MasterStudent;
import com.angers.project.inheritance.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 泛型类
 * 泛型类是具有一个或者多个类型变量的类
 * Java 使用大写字母来表示类型变量
 * E 表示集合的元素类型
 * K,V 表示表的 key 和 value 类型
 * T,U,S 等大写字母表示任意类型
 * 泛型类充当普通类的工厂
 * 虚拟机中没有泛型对象，所有的对象都属于一个普通类
 * 在编译的过程中，编译器会消除形参
 * 如果 T 没有任何约束条件，将会被替换为 Object
 * 如果有 extends 约束，将会被替换为第一个约束
 * Pair<T>类的泛型 T 将会直接被擦除,编译为：
 * public class Pair
 * 编译后的类和普通的类没有区别，就像泛型还未被添加到Java之前一样
 * TIPS：
 * 类型参数 T 不能使用基元类型实例化，只能是 Object
 * 对于 T 运行时的类型查询，仅适用于原始类型
 * a instanceof Pair<String> 是错误的，应该是
 * a instanceof Pair<T>
 */
@Slf4j
public class Pair <T> {

    /*
    泛型实例域，类型 T
    如果没有继承关系，实例域的类型也会被编译器转换为原始类型：
    private Object first;
     */
    private T first;
    private T second;

    /**
     * 无参构造器
     */
    public Pair(){
        first = null;
        second = null;
    }

    /**
     * 泛型构造函数
     * @param first 第一个类型变量
     * @param second 第二个类型变量
     * 类型变量 T 的使用贯穿整个类的定义，用于明确方法的返回类型以及局部实例域的类型
     * 构造函数编译后，类型会被消除：
     * public Pair(Object first,Object second)
     */
    public Pair(T first,T second){
        this.first = first;
        this.second = second;
    }

    /**
     * 实例域访问器方法
     * @return 返回类型为构造函数初始化实例域类型 T
     * 方法中的泛型类型被转换为原始类型
     * public Object getFirst()
     */
    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    /**
     * 实例域修改器方法
     * @param first 入参变量类型为构造函数初始化实例域类型 T
     */
    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    /**
     * 获取一个 String 数组中最长和最短的字符串
     * @param a 字符串数组
     * @return String 类型 Pair 对象, 数组中字典序的最大和最小值，如果 a 为空值则返回空
     */
    public static Pair<String> minAndMaxValue(String[]a){
        if ( a == null||a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (String v:a){
            if (min.compareTo(v)>0) min = v;
            if (max.compareTo(v)<0) max = v;
        }
        return new Pair<>(min,max);
    }

    /**
     * 查找一个类型数组中最大最小值对
     * @param a 泛型对象数组
     * @param <T> Comparable 接口约束的泛型对象
     * @return Pair<T> 类型对象
     * 使用泛型重写上面的方法
     * 泛型类会根据其约束条件进行实例化
     * 首先会实例化为 extends 修饰符后面最靠前的类
     * 如果继承了多个类或者接口，在特定场景下，编译器会为其插入转换代码
     * 比如在下面这个场景，编译器首先将 T 替换为 Serializable
     * 在使用 T 的过程中，使用到了 Comparable 的 compareTo 方法
     * 编译器则会为这些代码插入转换代码
     * 所以一般将标记接口（即没有具体方法的接口）放在后面，可以提高效率
     * 这个方法会被编译为：
     * public static Serializable minAndMaxValue(Serializable [] a)
     */
    public static <T extends Serializable & Comparable<T>> Pair<T> minAndMaxValue(T [] a){
        if (a==null||a.length==0) return null;
        T min = a[0];
        T max = a[0];
        for (T v:a){
            if (min.compareTo(v)>0) min = v;
            if (max.compareTo(v)<0) max = v;
        }
        return new Pair<>(min,max);
    }

    /**
     * 泛型方法，可以定义在常规的类中，也可以定义在泛型类中
     * @param a 类型参数 ，T... 表示传入任意数量的类型参数
     * @param <T> 类型变量，在 public static 修饰符之后
     * @return 类型变量值
     */
    public static <T> T middleValue(T... a){
        return a[a.length/2];
    }

    /**
     * 获取一个泛型数组中的最小值
     * @param a 泛型数组
     * @param <T> 因为需要通过 compareTo 方法进行比较，泛型数组的对象类必须是 Comparable 的子类
     * @return 最小值
     * 使用 extends 而不是 implements 表示 T 是 Comparable 的子类
     * T 可以是接口也可以是一个类
     * extends 更接近子类型的概念
     * 通过继承的关系，对于泛型类型变量进行约束，需要满足所继承接口或者类的特性
     * 如果需要附加多个约束条件，通过 & 分隔多个接口或者类，因为 , 逗号用来分隔多个泛型变量
     * 如果需要使用一个类作为约束，这个类必须作为第一个约束条件，而且只能使用一个类作为约束条件
     */
    public static <T extends Person & Comparable<T> & Serializable> T minValue(T[]a){
        if (a==null||a.length==0) return null;
        T minValue = a[0];
        for (T v:a){
            if (minValue.compareTo(v)>0) minValue = v;
        }
        return minValue;
    }

    public static void main(String [] args){
        String [] stringArrays = new String[]{"sea","class","cows","finance"};
        Pair<String> minMaxPair = minAndMaxValue(stringArrays);
        if (minMaxPair!=null)
            log.info("min:"+ minMaxPair.getFirst() +"; max:" +minMaxPair.getSecond());

        Pair<String> genericMinMaxPair = minAndMaxValue(stringArrays);
        if (genericMinMaxPair != null)
            log.info(genericMinMaxPair.getFirst()+genericMinMaxPair.getSecond());

        /*
        泛型方法会自动匹配参数类型
         */
        String middle = middleValue("and","beauty","season","son","crazy");
        log.info(middle);
        double middleDouble = middleValue(1.22,2.23,12.33);
        log.info(middleDouble+"");

        Employee an = new Employee(1000.00);
        Employee al = new Employee(2000.00);
        Employee [] employees = new Employee[]{an,al};
        Employee min  = minValue(employees);
        if (min!=null) log.info(min.toString());

        Pair<Employee> employeePair = new Pair<>(an,al);
        /*
        编译器翻译泛型表达式：
        编译器将这个调用转换为两个 JVM 指令
        1.调用原始的 Pair.getFirst() 方法
        2.将返回的 Object 转换为 Employee
         */
        Employee first = employeePair.getFirst();
        log.info(first.getSalary()+"");
        Pair<MasterStudent> masterStudentPair = new Pair<>();
        /*
        运行时的类型查询只会返回原始类型
        masterStudentPair.getClass() 和 employeePair.getClass() 都会返回 Pair.class
         */
        log.info(masterStudentPair.getClass()+","+employeePair.getClass());

        /*
        不能定义参数类型数组
        如果需要手机类型参数，可以使用 ArrayList
         */
        // Pair [] pairs = new Pair<Employee>[1]; 这种定义是错误的
        ArrayList<Pair<Employee>> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employeePair);
        log.info(employeeArrayList.get(0).getFirst().toString());
    }
}