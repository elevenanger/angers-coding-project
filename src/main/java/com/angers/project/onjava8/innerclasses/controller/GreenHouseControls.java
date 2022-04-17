package com.angers.project.onjava8.innerclasses.controller;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/16 16:29
 * @description : 内部类-时间驱动系统
 * 在一个类中使用内部类实现多个版本的 Event 派生类
 * 每个派生类型实现相应的控制代码
 */
public class GreenHouseControls extends Controller {
    /*
    灯泡点亮状态
    false 熄灭
    true 点亮
     */
    private boolean light = false;

    /**
     * 点亮灯泡
     */
    public class LightOn extends Event {
        // 构造函数
        public LightOn(Long millSecondDelay) {
            super(millSecondDelay);
        }

        /**
         * 实现具体控制逻辑
         */
        @Override
        public void action() {
            // 点亮灯泡
            light = true;
        }

        @Override
        public String toString() {
            return "LightOn";
        }
    }

    /**
     * 熄灭灯泡
     */
    public class LightOff extends Event {
        public LightOff(Long millSecondDelay) {
            super(millSecondDelay);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "LightOff";
        }
    }

    /**
     * run 方法插入一个新的该类对象进入事件列表
     */
    public class Bell extends Event {
        public Bell(Long millSecondDelay) {
            super(millSecondDelay);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime.toMillis()));
        }

        @Override
        public String toString() {
            return "Bell Ring!";
        }
    }

    public class Restart extends Event {
        private Event [] events;

        /**
         * 使用事件列表，重置系统状态
         * @param millSecondDelay 延迟时间
         * @param events 事件列表
         */
        public Restart(Long millSecondDelay, Event[] events) {
            super(millSecondDelay);
            this.events = events;
            // addEvent 不是 static 方法，使用lambda 表达式要指定当前内部类对象
            Arrays.stream(events).forEach(GreenHouseControls.this::addEvent);
        }

        @Override
        public void action() {
            Arrays.stream(events).forEach(event -> {
                event.start();
                addEvent(event);
            });
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restart";
        }
    }

    /**
     * 结束事件
     */
    public static class Terminate extends Event {
        /**
         * 结束控制系统
         * @param millSecondDelay 延迟时间，在此时间后退出整个系统
         */
        public Terminate(Long millSecondDelay) {
            super(millSecondDelay);
        }

        @Override
        public void action() {
            // 退出整个 JVM
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating...";
        }
    }

    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        gc.addEvent(gc.new Bell(1000L));
        Event [] events = {
                gc.new LightOn(200L),
                gc.new LightOff(500L),
        };
        gc.addEvent(gc.new Restart(1000L,events));
        gc.addEvent(new GreenHouseControls.Terminate(5000L));
        gc.run();
    }
}


