package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;
import com.angers.project.onjava8.validating.Timer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/19 09:20
 * @description :
 */
public class Pizza {
    public enum Step{
        DOUGH(4), ROLLED(1), SAUCED(1), CHEESED(2),
        TOPPED(5), BAKED(2), SLICED(1), BOXED(0);
        int effort;
        Step(int effort){
            this.effort = effort;
        }
        Step forward(){
            /*
            如果已经装箱
            整个流程已经结束
            返回最终的状态
             */
            if (equals(BOXED)) return BOXED;
            new Nap(effort * 0.1);
            return values()[ordinal() + 1];
        }
    }
    public Step step = Step.DOUGH;
    private final int id;

    public Pizza(int id) {
        this.id = id;
    }

    public Pizza next() {
        step = step.forward();
        System.out.println("Pizza" + id + " : " + step);
        return this;
    }

    public Pizza next(Step pre){
        if (!step.equals(pre))
            throw new IllegalStateException(
                    "Expected pre " + pre + " but found " + step
            );
        return next();
    }

    public Pizza roll() {return next(Step.DOUGH);}
    public Pizza sauce() {return next(Step.ROLLED);}
    public Pizza cheese() {return next(Step.SAUCED);}
    public Pizza toppings() {return next(Step.CHEESED);}
    public Pizza bake() {return next(Step.TOPPED);}
    public Pizza slice(){return next(Step.BAKED);}
    public Pizza box() {return next(Step.SLICED);}
    public boolean complete() {
        return step.equals(Step.BOXED);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "step=" + step +
                ", id=" + id +
                '}';
    }

    public static CompletableFuture<Pizza> makePizzaCF(Pizza pizza){
        return CompletableFuture
                .completedFuture(pizza)
                .thenApplyAsync(Pizza::roll)
                .thenApplyAsync(Pizza::sauce)
                .thenApplyAsync(Pizza::cheese)
                .thenApplyAsync(Pizza::toppings)
                .thenApplyAsync(Pizza::bake)
                .thenApplyAsync(Pizza::slice)
                .thenApplyAsync(Pizza::box);
    }
    public static void show(CompletableFuture<Pizza> cf){
        try {
            System.out.println(cf.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        /*
        制作一个 pizza
        整个过程是线性的
         */
        Pizza onePizza = new Pizza(0);
        System.out.println(Timer.duration(
                () -> {
                    while (!onePizza.complete()) onePizza.next();
                }
        ));

        int quantity = 10;
        /*
        使用 Stream
        批量创建 Pizza
         */
        Timer timer = new Timer();
        IntStream.range(0,quantity)
                .mapToObj(Pizza::new)
                .parallel()
                .forEach(pizza -> {
                    while(!pizza.complete()) pizza.next();
                });
        System.out.println(timer.duration());

        /*
        使用 map 处理每一个步骤
        时间并没有缩短
         */
        timer = new Timer();
        IntStream.range(0,quantity)
                .mapToObj(Pizza::new)
                .parallel()
                .map(Pizza::roll)
                .map(Pizza::sauce)
                .map(Pizza::cheese)
                .map(Pizza::toppings)
                .map(Pizza::bake)
                .map(Pizza::slice)
                .map(Pizza::box)
                .forEach(System.out::println);
        System.out.println(timer.duration());

        timer = new Timer();
        List<CompletableFuture<Pizza>> pizzas =
                IntStream
                        .range(0,quantity)
                        .mapToObj(Pizza::new)
                        .map(Pizza::makePizzaCF)
                        .collect(Collectors.toList());
        System.out.println(timer.duration());
        pizzas.forEach(Pizza::show);
        System.out.println(timer.duration());
    }
}
