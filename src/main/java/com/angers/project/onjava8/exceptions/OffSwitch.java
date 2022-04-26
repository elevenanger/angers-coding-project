package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 19:12
 * @description : 异常-在finally 语句中执行关闭操作
 */
public class OffSwitch {
    private static Switch sw = new Switch();
    static void f() throws OnOffException1,OnOffException2 {}

    public static void main(String[] args) {
        try {
            System.out.println("close with try-catch");
            sw.on();
            f();
            sw.off();
        }catch (OnOffException1 e){
            System.out.println("exception1");
            sw.off();
        }catch (OnOffException2 e){
            sw.off();
        }
        System.out.println(sw);
        try {
            System.out.println("close with finally");
            sw.on();
            f();
        }catch (OnOffException1 e){
            System.out.println("e1");
        }catch (OnOffException2 e){
            System.out.println("e2");
        }finally {
            sw.off();
        }
        System.out.println(sw);
    }
}

class Switch {
    private boolean state = false;
    void read(){
        state = true;
        System.out.println(this);
    }
    void on(){
        this.state = true;
        System.out.println(this);
    }

    void off(){
        this.state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "state=" + state +
                '}';
    }
}

class OnOffException1 extends Exception{}
class OnOffException2 extends Exception{}
