package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 08:42
 * @description : 函数-lambda表达式
 */
public class Strategies {
    Strategy strategy;
    String msg;

    public Strategies(String msg) {
        strategy = new Soft(); // Soft 是 Strategies 成员变量 strategy 的默认值，在构造函数完成初始化
        this.msg = msg;
    }

    void communicate () {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy [] strategies = {
                /*
                使用匿名内部类构造 Strategy 对象
                 */
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase()+ "!";
                    }
                },
                /*
                java 8 lambda 函数表达式
                通过箭头 -> 区分参数和函数体
                箭头右侧是 lambda 函数表达式
                它和定义类以及匿名内部类产生相同的效果
                 */
                msg -> msg.substring(0,5),
                msg -> msg.substring(6,11),
                /*
                java 8 方法引用
                通过 :: 区分
                左边是类名或者对象
                右边是方法名，但是不带参数
                 */
                Unrelated::twice
        };
        Strategies s = new Strategies("Hello there");
        s.communicate();
        for (Strategy st:strategies) {
            s.changeStrategy(st); // 遍历 strategies ，将其中的每一个 Strategy 应用到 Strategies s 中
            /*
            每个不同的 Strategy 应用到  Strategies.communicate() 方法都会产生不同的行为
            取决于当前使用的 "代码对象"
            这里传递的是行为代码：
            msg -> msg.substring(0,5),
            msg -> msg.substring(6,11),
            Unrelated::twice
            而不是对象数据
             */
            s.communicate();
        }
    }
}

interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice (String msg){
        return msg+ " " + msg;
    }
}