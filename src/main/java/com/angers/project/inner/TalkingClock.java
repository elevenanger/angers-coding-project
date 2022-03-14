package com.angers.project.inner;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * 蜂鸣器时钟
 */
@Slf4j
public class TalkingClock {

    /*
    时间间隔
    如果通过本地内部类构造对象，实例域需要是 final 修饰的，意味着对象构造完成之后就无法修改
    因为在本地内部类实例化的过程中实例域的值会被传递给本地内部类的构造函数并赋值给其实例域
    外部方法无法操作本地内部类对象
     */
    private final int interval;

    /*
    凤鸣状态
     */
    private final boolean beep;

    /**
     * 蜂鸣器时钟构造函数
     * @param interval 时间间隔
     * @param beep 蜂鸣器状态
     */
    public TalkingClock(int interval,boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        /*
        本地内部类
        在当前类中，只有 start() 方法使用到内部类 TimePrinter 创建 TimePrinter 对象
        在这种情况下，可以使用在方法内定义本地内部类
        本地内部类不需要通过访问修饰符进行声明
        它的作用域被严格限制在声明它的代码块中
        本地内部类的优势在于其对外完全不可见，除了声明它的方法，即使是 TalkingCLock 的其它代码也无法访问它
         */
        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("TimePrinter : The time is: " + Instant.ofEpochMilli(e.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 匿名启动器：使用匿名内部类特性
     * @param interval 间隔时间
     * @param beep 蜂鸣标识
     * 如果只需要对某个类构造一个实例化的对象 (实现了 ActionListener 接口的类) 不需要使用类名来定义该类
     * 这种类称为 匿名内部类
     */
    public void anonymousStart(int interval,boolean beep){
        /*
        构造参数的右括号后面跟着左大括号则表示正在定义一个匿名内部类
        new SuperType(construction parameters){ inner class method and data};
        SuperType: 可以是接口，也可以是类
        是接口则匿名内部类实现该接口
        是类则匿名内部类集成该类
        匿名内部类没有自己的构造函数，因为构造函数名必须和类名相同，但是它没有类名
        构造参数用于构造其超类
        如果匿名内部类实现了某个接口，它就没有任何构造参数（等同于接口的特性，接口不是类，无法独立进行构造初始化）
         */
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("AnonymousStarter : The time is: " + Instant.ofEpochMilli(e.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }; // 匿名内部类
        Timer timer = new Timer(interval,listener);
        timer.start();
    }

    /**
     * 使用函数式编程实现蜂鸣启动器
     * @param interval 间隔时间
     * @param beep 蜂鸣标识
     */
    public void anonymousStarterWithFunction(int interval,boolean beep){
        Timer timer = new Timer(interval,event -> {
            log.info("AnonymousStarterWithFunction : The time is: " + Instant.ofEpochMilli(event.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
    }
    /**
     * 内部类，时间打印器
     * 内部类对象由外部类的方法构造
     * 内部类声明为 private 则仅有其外部类方法能够创建它
     */
/*
    public class TimePrinter implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            log.info("The time is: " + Instant.ofEpochMilli(e.getWhen()));
            /*
            发出蜂鸣之前，检查 beep 标识
            内部类 TimePrinter 没有人和实例域或者变量名为 beep
            beep 引用的是构造了 TimePrinter 的 TalkingClock 对象
            内部类对象总是拥有对于创建其外部对象的隐式的引用
            外部类的引用在构造函数中设置
            编译器修改所有内部类的构造函数，在其中增加一个对外部类的引用的参数
            TimePrinter 没有构造函数，所有会自动生成一个无参构造函数，并将这个参数添加到其中
            内部类可以访问它本身的实例域以及构造它的外部对象的实例域
            所以通过内部类访问外部类的实例域无需写 public 访问器方法，对于仅仅是内部类需要使用的这个域，这种方式特别有用
             * /
            if (beep) Toolkit.getDefaultToolkit().beep();
        }

    }
*/
    public static void main(String [] args){

        TalkingClock clock = new TalkingClock(1000,true);
        clock.anonymousStarterWithFunction(1000,true);
        JOptionPane.showMessageDialog(null,"退出？");
        System.exit(0);

        /*
         显式地构造内部类对象：
         通过外部类对象构建 outerObject.new InnerClass (construction parameters)
         如果内部类是 public 的，则可以通过任意的外部类构造内部类对象
         通过外部类引用 OuterClass.InnerClass 引用内部类，它发生在外部类范围之外
         */
        // TalkingClock.TimePrinter printer = clock.new TimePrinter();
    }
}
