package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;
import com.angers.project.onjava8.validating.Timer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author : liuanglin
 * @date : 2022/5/17 18:58
 * @description : 并发-结合机器模型使用 CompletableFuture
 */
public class Machina {

    /*
    State 枚举是一个有限状态机
    它没有分支
    沿着既定的路径从头到尾进行状态的转化
     */
    public enum State {
        START,ONE,TWO,THREE,END;
        /*
        状态机状态流转的方法
        每次调用该方法根据当前状态位进一位
        知道 END 状态
         */
        State step(){
            if (equals(END)) return END;
            return values()[ordinal() + 1];
        }
    }

    // 设置初始状态
    private State state = State.START;
    private final int id;

    public Machina(int id) {
        this.id = id;
    }

    /**
     * 机器工作逻辑
     * @param machina 机器对象
     * @return 执行完工作逻辑的机器对象
     */
    public static Machina work(Machina machina){
        // 状态变化，调用 State.step() 方法
        if (!machina.state.equals(State.END)) {
            new Nap(0.1);
            machina.state = machina.state.step();
        }
        System.out.println(machina);
        return machina;
    }

    @Override
    public String toString() {
        return "Machina{" +
                "state=" + (state.equals(State.END)?"complete" : state) +
                ", id=" + id +
                '}';
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Timer timer = new Timer();
        /*
        创建一个已经完成的 CompletableFuture 实例
        CompletableFuture.completedFuture(new Machina(0))
        当前该实例唯一有用的事情是获取其中的对象
        cf.get()
        CompletableFuture 被键入到它锁包含的对象
         */
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        Machina machina = cf.get();
        System.out.println(machina);
        /*
        thenApply() 方法接收一个函数作为输入然后产生结果
         */
        cf.thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);
        System.out.println(timer.duration());

        timer = new Timer();

        CompletableFuture<Machina> cf1 = CompletableFuture.completedFuture(new Machina(1));
        cf1.thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);
        System.out.println(timer.duration());
        System.out.println(cf.join());
        System.out.println(timer.duration());
    }
}
