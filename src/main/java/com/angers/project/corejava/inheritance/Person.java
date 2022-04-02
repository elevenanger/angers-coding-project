package com.angers.project.corejava.inheritance;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Objects;

/**
 * abstract 类 person
 * 父类变得非常通用，可以抽象为其它类的基础，而不需要实例化
 * 抽象类无法被实例化
 */
@Slf4j
public abstract class Person implements Serializable {

    /*
    实例域 instance fields
    对象实例域必须是 private 修饰符，防止被其它的操作使用或者修改
    static 修饰符标识每个 类 只有一个 nextId 域，static 是作用于类的，Employee 类实例化的 Employee 对象，共享 nextId 的值
    即使没有实例化的 Employee 对象，static 域 nextId 的值也是存在的，它属于 Employee 类，而不是某个实例化的对象
     */
    private static int nextId = 1;

    // 非 static 域，每个实例化的对象都有属于自己的一份当前实例域的副本
    private int id ;

    /**
     * 姓名，抽象类可以拥有字段
     * 将更通用的字段和方法转移至超类
     */
    private String name;

    /**
     * 抽象类可以拥有具体实现的方法
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * static 方法同样作用于类，而非某一个具体的对象，没有 this 参数
     * static 方法可以访问 static 域
     * 以下两种情况使用 static 方法：
     * 1.不需要访问具体对象的方法
     * 2.只需要访问类的 static 域的方法
     */
    public static int getNextId(){ return nextId; }

    // accessor（访问器）方法 methods
    public int getId(){ return this.id ; }

    // 使每个实例化的ID对象等于当前 static 域的值，实现自增的效果
    public void setId(){
        this.id = nextId;
        nextId++;
    }

    /**
     * @param name 姓名
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取个人简介
     * 定义抽象的方法，不需要进行实现
     * 抽象的方法充当在子类中实现的具体方法的占位符
     * 对于父类的抽象方法，子类有两种选择：
     * 1.子类不是抽象类，实现父类所有的抽象方法
     * 2.子类也可以继续作为抽象类，保留父类一个或者多个抽象方法为未定义的方法
     * 当一个类存在一个或者多个 abstract 方法，这个类必须被声明为 abstract 类
     * @return null
     */
    public abstract String getDescription();

    /**
     * 重写 Object.equals() 方法,当两个对象的类型和名字都相等时则相等
     * Object 是所有对象的超类，新建类时，无需特别声明继承关系
     * 在 Java 中，只有基元数据类型（数值、字符、布尔值）不是对象类型，其它数据类型都是对象类型
     * @param anotherObject 另一个对象
     * @return 两个 person 是否相等
     */
    @Override
    public boolean equals(Object anotherObject){
        // 首先判断是否相同，如果相同则无需再比较实例域，效率更高
        if (this==anotherObject){
            return true;
        }
        // 比较对象不能为空对象
        if (anotherObject==null){
            return  false;
        }
        /*
         如果子类比较域的语义可能发生变化，则使用 getClass() 进行判断
         如果比较域的语义适用于所有的子类，则可以使用 instanceof 进行测试，与 getClass() 测试二选一
         比如我们使用 id 来判断两个对象变量是否是相等
         对于一个 Person a
         a 是一个 MasterStudent
         a 同时也是一个 Employee
         对于 a 来说，MasterStudent 和 Employee 都是 Person 实例化的对象，对应同一个 Person.id
         这种情况下 id 在 MasterStudent 和 Employee 语义上是相同的，应该使用 instanceof 进行判断
         */
//        if (anotherObject.getClass()!=this.getClass()){
//            return false;
//        }
        log.info("实例化比较"+(anotherObject instanceof Person));
        if ( ! (anotherObject instanceof Person)){
            return false;
        }
        // 将 otherObject 转换为相同类型的对象变量
        Person anotherPerson = (Person) anotherObject;
        log.info("ID:"+anotherPerson.getId());
        /*
        比较实例域
        用 == 比较基元数据类型域
        用 equals 比较对象变量域
         */
        return this.getName().equals(anotherPerson.getName())
                && this.getId()==anotherPerson.getId();
    }

    /**
     * Person hashCode() 方法
     * 重写 equals() 方法 ，需要重写 hashCode() 方法，用户可以将对象插入 hash 表
     * Object 默认的 hashCode() 方法从对象的内存地址生成 hash 码
     * 使用判定 equals 的域来生成 hash 码，即 如果 a.equals(b) = true ,则 a.hashCode() = b.hashCode()
     * @return hash(id,name)
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * Person 转换成 String
     * 如果一个类有 toString() 方法,当该类实例化对象被 + 号连接时，编译器会自动调用 toString() 方法进行对象的展示和连接
     * @return person string
     */
    @Override
    public String toString() {
        return getClass().getName()+"{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String [] args){
        /*
        抽象类无法实例化，但是可以创建抽象类的对象变量，该变量的值必须引用一个非抽象的子类实例化对象
         */
        Person an = new MasterStudent();
        an.setName("An");
        Person.nextId = 1;
        Manager anM = new Manager();
        anM.setName("An");
        MasterStudent anNew = new MasterStudent();
        anNew.setName("An");
        Person [] persons = new Person[] {an,anM,anNew};
        for (Person p :persons){
            log.info(""+p);
        }

        log.info(an.equals(anM)+","+an.equals(anNew));
    }

}
