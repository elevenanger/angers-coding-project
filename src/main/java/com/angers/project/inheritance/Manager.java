package com.angers.project.inheritance;

import lombok.extern.slf4j.Slf4j;

/**
 * 管理员类，继承于 Employee ，是其子类(subclass) ，被继承的 Employee 为超类(superclass)
 * 基于管理员有别于普通雇员的特性，定义一个新的类，基于 Employee 衍生的 Manager 类，定义其特有的实例域和方法
 * 每个 Manager 都是一个 Employee ，这个关系决定了其继承的标志
 * Java extends 保留字表示继承关系
 * final 修饰符标识这个类无法被继承
 * final 类所有的方法都会被自动加上 final 修饰符，final 类之中的实例域不会受这个影响
 * attention：只有类或者方法在语义上很明确，不能再被修改才使用 final 修饰符
 */
@Slf4j
public  final class Manager extends Employee {

    /**
     * 福利金额
     */
    private double bonus;

    /**
     * @param bonus 福利金额
     */
    public void setBonus(double bonus){ this.bonus = bonus;}

    /**
     * @return 子类覆盖（Override）超类的方法，salary = baseSalary + bonus
     * 当超类的方法不适用于子类时，需要提供一个新的方法覆盖超类的方法 @Override 注解标识覆盖
     * 覆盖超类的方法，子类方法的可见性要不低于超类的方法，超类是 public ，子类也需要至少是 public
     * 和作用于类一样，final 修饰符标识这个方法无法被覆盖
     *
     */
    @Override
    public final double getSalary() {
        /*
          调用超类方法正确的写法：
          1.return salary+bonus; 错误写法
          salary 是 Employee 的 private 域，Manager 不能直接访问
          只能通过 Employee 提供的 public 接口: getSalary() 访问
          2.改成 getSalary()+bonus; 这种写法也是错误的
          因为 Manager 类也有 getSalary() 方法，即我们需要实现的这个方法
          这种写法会使其调用自身的 getSalary() 方法，导致无限调用循环
          我们需要明确指出我们想要调用超类 Employee 的 getSalary() 方法
          这种情况下需要使用 super 关键字，即：super.getSalary()
         */
        double baseSalary = super.getSalary();
        return baseSalary+this.bonus;
    }

    @Override
    public String getDescription() {
        return this.getName()+" is a manager";
    }

    /**
     * Manager 构造函数 子类构造函数
     * @param name 姓名
     * @param baseSalary 基本工资
     * @param year 入职年份
     * @param month 入职月份
     * @param day 入职日期
     */
    public Manager(String name,double baseSalary,int year,int month,int day){
        /*
        调用超类的构造函数
        Manager 无法直接访问 Employee 的 private 域，须通过超类的构造函数完成初始化
        超类的构造器通过 super 语法调用
        使用 super 的调用父类构造器，必须是子类构造器的第一条语句
        attention：
        如果子类的构造函数没有显式地调用父类的构造函数：
        1.父类有无参构造函数，即调用父类的无参构造函数
        2.父类没有无参构造函数， Java 编译器将会报错
         */
        super(name,baseSalary,year,month,day);
        // 子类构造函数其它的初始化或者方法调用语句（代码）必须在 super 构造函数之后
        super.modifyEvaluations("bs");
        // 初始化子类域，设置默认的 bonus 值为 1000
        bonus = 1000;
    }

    public static Manager initCEO(){
        Manager ceo = new Manager();
        ceo.setName("Boss.CEO");
        return ceo;
    }

    /**
     * 无参构造函数
     */
    public Manager(){
    }

    @Override
    public String toString() {
        return super.toString() +"{"+
                "bonus=" + bonus +
                ",realSalary=" + getSalary()+
                '}';
    }

    public static void main(String [] args){
        Manager wong = new Manager("Wong",12000.00,2011,10,12);
        Employee sun = new Employee("Sun",5000.00,2012,12,11);
        Employee qin = new Employee("Qin",3000.00,2013,2,12);
        Employee [] employees = new Employee[3];
        employees [0] = wong;
        employees [1] = sun;
        employees [2] = qin;
        /*
        可以使用 wong.setBonus() ，但是不能使用 employees [0].setBonus()
        employees [0] 和 wong 都是引用同一个对象
        但是数组 Employee [] employees 声明类型是 Employee ，setBonus() 是 Manager 的方法
         */
        /*
        比较Manager 和 Employee，Manager 的 salary
        e 的声明类型是 Employee ，但是 e 引用的实际类型既可以是 Employee ，也可以是 Manager
        e 引用 Employee 对象，getSalary() 调用 Employee 的 getSalary() 方法
        e 引用 Manager 对象，getSalary() 调用 Manager 的 getSalary() 方法
        JVM 知道 e 引用的实际对象类型，根绝对象类型调用正确的方法
        一个 对象变量 可以引用多种对象类型，称之为多态（polymorphism）
        这种在运行时自动选择合适的方法的机制，称之为动态绑定（dynamic binding）
        动态绑定有一个重要的属性-可扩展性：在不修改现有代码的前提下进行扩展
        attention 运行时，getSalary() 解析过程:
        1. JVM 查找方发表（JVM预生成的列表，包含类、方法和方法签名清单），获取 e 的实际类型
        2. JVM 根据入参和 e 的类查找 getSalary() 的方法签名，确定需要调用的方法
        3. JVM 调用对应的方法
        替换原则（substitution principle）:使用超类对象时，同样可以使用子类对象进行替换
        超类对象变量 e 可以引用子类对象 wong
        与之相对的，不能使用 Manager m = employees[0]
        首先，不是每个 Employee 都是 Manager
        其次， employees[0] 如果引用一个 Employee 对象不是一个 Manager 对象， m.setBonus() 将会报错
         */
        for (Employee e :employees){
            /*
            将 e 强制转换为 Manager
            为了避免 ClassCastException ，转换之前先使用 instanceof 判断 e 是不是一个 Manager 实例
            只有在继承的层次结构才能进行强制转换
             */
            if (e instanceof Manager){
                ((Manager) e).setBonus(20000);
            }
            log.info("id:"+e.getId()+
                    ",name:"+e.getName()+
                    ",salary:"+e.getSalary()+
                    ",hireDate:"+e.getHireDate()+
                    ",evaluations:" +e.getEvaluations().toString()+
                    ",description:"+e.getDescription());
        }
    }

}
