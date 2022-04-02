package com.angers.project.corejava.inheritance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 雇员类
 * extends 继承 Person 类
 * 继承 abstract 基类来表达通用的属性
 * implements 实现 Comparable 接口,使用 Employee 形参
 * 实现 Cloneable ，使对象可以使用 clone() 方法
 * 一个类只能继承自一个超类，但是可以实现多个接口
 * 实现接口可以规避多重继承的低效和复杂度，并提供多重继承的好处
 */
@Slf4j
public class Employee extends Person implements Comparable<Employee>,Cloneable, Serializable{


    /*
    static 常量，因为 static 是作用于类的，不需要构造对象即可以使用该常量
    尽量不要有 public 域，因为一旦公开即可被任意的使用和修改，但是 public 常量是 final 域，引用的对象永远是同一个
     */
    public static final String LEVEL = "NORMAL";

    /*
    薪水
     */
    private double salary;

    /*
    final instance fields
    final 实例域必须在对象构造的时候完成初始化，这个实例域在对象构造完成后将无法被改变
    final 实例域对于基元数据域或者不可变的类非常有用(一个类没有修改器方法，就称之为不可变的类)
    protected 修饰符标识这个域或者方法可以被其子类以及同一包下的其它类所访问
     */
    protected final LocalDate hireDate;

    /*
    final 实例域修饰一个类型为可变类的数据域
    对于可变的类，代表 evaluations 变量引用的 StringBuilder 对象将不会改变，但是对象本身是可变的
    通过修改器方法可以对这个对象进行修改
    评价
     */
    private final StringBuilder evaluations ;

    /*
    构造函数 constructor
    构造函数与类名相同
    一个类可以有多个构造函数
    构造函数可以接收0，1或者任意个参数
    构造函数没有 return 值
    构造函数只能使用 new 操作符调用
    构造完成的对象在堆内存中
     */
    public Employee(String n,double s,int year,int month,int day){
        setId();
        setName(n);
        salary = s;
        hireDate = LocalDate.of(year,month,day);
        evaluations = new StringBuilder();
    }

    /**
     * 构造函数，匿名雇员，一个类可以存在多个构造函数
     * 这种机制称之为：重载（overload），如果多个方法的名称相同，但是参数不同，编译器必须通过参数类型找出需要调用的方法
     * @NonNull 注解表示该参数不能为空
     * @param s 薪水
     */
    public Employee ( @NonNull double s){
        setId();
        setName("Anonymity");
        salary = s;
        // final 修饰符实例域必须在构造函数中完成初始化
        hireDate = LocalDate.now();
        // 通过 private 私有方法调用完成 final 域初始化
        evaluations = new StringBuilder();
        initialLocalEvaluations();
    }

    /*
    无参构造器，不需要传参，为所有的实例域设置一个合适的值
    如果一个类中没有写任何的构造函数，java 会提供一个无参构造器，为所有的实例域设置默认值
    如果一个类提供了至少一个构造函数，但是没有提供无参构造函数，则无法通过不传参数构造对象
     */
    public Employee(){
        setId();
        setName("");
        salary = 0;
        hireDate = LocalDate.now();
        evaluations = new StringBuilder();
    }

    public double getSalary(){ return this.salary; }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    public  StringBuilder getEvaluations () { return this.evaluations; }

    @Override
    public String getDescription() {
        return this.getName()+" is a normal employee";
    }

    /**
     *
     * @param salary 薪水
     */
    public void setSalary(int salary){
        this.salary = salary;
    }

    /**
     * 调整工资，传入百分比，对当前的 salary 进行计算，然后赋值给 salary
     * mutator (修改器) 方法
     * 这个方法有一个隐式的参数,值为：Employee 对象的引用
     * 1.x初始化为入参对象变量的副本：引用同一个 Employee 对象
     * 2.adjustSalary 方法作用于这个对象引用，x和入参所引用的同一个 Employee 对象的 salary 发生了改变
     * 3.方法结束后，参数变量 x 不再使用，但是对象变量所引用的 Employee 对象的 salary 已经发生了改变，对象的状态也已经发生了改变
     * @param rate 薪水提升比例
     */
    public void adjustSalary(int rate){
        // 增加 rate 百分比的薪水，因为 salary 是double类型数值，对于 rate 的计算应该除以一个浮点数 100.00
        double raise  = this.salary*rate/100.00;
        // 使用 this 引用隐式的 Employee 对象参数
        this.salary+=raise;
    }

    /**
     * 增加薪水
     * @param rate double
     */
    public Employee adjustSalary(Double rate){
        this.salary+=salary*rate;
        return this;
    }
    /**
     * private 修改器方法，修改 final 域
     */
    private void initialLocalEvaluations(){
        this.evaluations.append("nb");
    }

    /**
     * public 修改器方法，修改 final 域
     * @param appendString 描述字符串
     */
    public void modifyEvaluations(String appendString){
        this.evaluations.append(appendString);
    }

    /*
    java 语言总是使用按值调用（call by value）
    方法的入参是参数的值的副本
    方法不能改变任何传入参数变量的内容
     */
    public static void tripleValue(int x){
        /*
         1.x 初始化为入参变量的副本
         2.x扩大了三倍，但是入参原始变量的值仍然是原值
         方法结束后，x就无用了
         */
        x = x*3;
    }

    /*
    static 构造方法，工厂方法
    使用静态工厂方法构造对象，可以是使用者忽略对象具体细节
    构造器名只能与类名相同，无法区分同一种对象不同的实例
    使用构造器，不能修改构造对象的类型
     */
    public static Employee getWellPaidInstance(String n){
        Employee wellPaidMan = new Employee(n,1000000.00,2022,2,17);
        wellPaidMan.modifyEvaluations("rc");
        return wellPaidMan;
    }

    public static Employee initWellPaidInstance(){
        Employee wellPaidMan = new Employee("richer",1000000.00,2022,2,17);
        wellPaidMan.modifyEvaluations("rc");
        return wellPaidMan;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "salary=" + salary +
                ", hireDate=" + hireDate +
                ", evaluations=" + evaluations +
                '}';
    }

    /**
     * 比较两个 Employee 的工资是否相等
     * 实现 Comparable 接口的方法
     * @param o 需要比较的对象
     * @return 0 相等，1 比较对象较大 ，-1 当前对象较大
     */
    public int compareTo(Employee o) {
        return Double.compare(this.getSalary(),o.getSalary());
    }

    /**
     * 创建 Employee Stream
     * @param filename 文件名，绝对路径
     * @return Employee Stream
     * @throws IOException 文件不存在等 IO 异常
     */
    public Stream<Employee> createEmployeeStreamFromFile(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .map(Employee::getWellPaidInstance)
                .map(employee -> employee.adjustSalary(Math.random()));
    }

    public static void main(String [] args){
        // 通过 Employee 类的构造函数构造对象，并为数组赋值，引用堆内存中的对象地址
        // 构造函数只能与 new 操作符一起调用
        Employee jack = new Employee("Jack",10000.00,1990,10,21);
        Employee calvin = new Employee("Calvin",12000.00,1992,11,21);
        Employee carter = new Employee("Carter",9000.00,1995,2,12);
        // 使用另一个构造函数构造对象，一个类可以有多个构造函数
        Employee nobody = new Employee(1000.00);
        // 使用工厂方法构造对象
        Employee rich  = Employee.getWellPaidInstance("Rich");
        jack.modifyEvaluations("jj");
        calvin.modifyEvaluations("cc");
        carter.modifyEvaluations("ct");
        //直接使用对象赋值给数组
        Employee [] staff = new Employee[]{jack, calvin, carter, nobody,rich};
        /*
        根据 Arrays.sort() 方法的定义，需要对数组进行排序，需要实现 Comparable 接口
        Employee 实现了 Comparable 的 CompareTo 方法，排序的结果将按照 CompareTo 方法比较的结果进行排序
        salary 较大的排在前面
        java 是强类型的语言，编译器必须知道 staff 的每一个对象都是 Comparable 的，拥有 CompareTo 方法
        通过接口来实现
         */
        Arrays.sort(staff);
        // 初始化一个基元(primitive type)类型 int 数值 rate ,值为 5
        int rate = 5;
        // 将 rate 作为参数，传入 tripleValue 方法
        tripleValue(rate);
        // 调用完成之后，打印 rate 的值，仍为 5，基元类型参数的数值未被改变
        log.info("after method call,rate is:"+rate);

        // 遍历数组，读法：对于每一个 Employee 对象实例 e , 遍历数组  staff
        for (Employee e : staff){
            /*
            调用对象类的 adjustSalary 方法
            这个方法有两个参数，一个是隐式的，是这个方法操作的 Employee 对象，也称之为 target （目标），或者 receiver （接受者）
            一个是显式的参数，是括号内传入的值 5
            对于对象类型参数，经过方法调用后，对象的状态发生了改变
            */
            e.adjustSalary(rate);
        }

        //遍历数组，打印每一个 Employee 对象信息
        for (Employee e : staff){
            log.info("id:"+e.getId()+
                    ",name:"+e.getName()+
                    ",salary:"+e.getSalary()+
                    ",hireDate:"+e.getHireDate()+
                    ",evaluations:" +e.getEvaluations().toString()+
                    ",description:"+e.getDescription());
        }
        // 对于 static 修饰的 public 常量，不需要构造对象通过类名即可直接使用
        log.info(Employee.LEVEL);
        // 对于 static 方法，也可以直接通过类名进行调用
        log.info("currentId : " + getNextId());

        /*
        声明一个数组列表
        可以指定初始化的长度，也可以不指定
        数组列表管理对象引用列表
        数组列表的长度是可以自动调整的，如果对象的数量超过了初始化的长度，将会自动创建一个更大的数组将原来的数据拷贝到新的数组
        这里指定了数组的长度为100，则前100次调用 add 往数组中新增对象引用将不会有重新分配内存空间的开销
         */
        ArrayList<Employee> employees = new ArrayList<>(100);
        employees.add(jack);
        employees.add(calvin);
        employees.add(carter);
        Manager boss = new Manager();
        boss.setName("Abo");
        boss.setSalary(100000);
        boss.setBonus(10000);
        employees.add(boss);
        log.info("遍历数组列表,长度为："+employees.size());
        for (Employee e:employees){
            log.info(e.toString());
        }
    }

}
