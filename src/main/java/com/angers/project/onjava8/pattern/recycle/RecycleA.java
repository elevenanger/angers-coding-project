package com.angers.project.onjava8.pattern.recycle;

import com.angers.project.onjava8.pattern.trash.*;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/25 15:47
 * @description : 回收站-将垃圾转换成有价值的材料
 * 材料工厂
 */
class SimpleTrashFactory {
    /*
    Trash 构造函数列表
    Trash 构造函数都是接收 double 参数 返回 Trash 对象
    与 Function<Double,Trash> 函数一样
    这里使用函数对象来表示构造函数
    没有 CardBoard 构造函数

    现在这个方法是奏效的
    但是如果系统扩展
    Trash 的类型增加了
    构造 Trash 对象需要更多的信息
    每次调整都需要将代码中所有相应的地方进行调整

    如果设计太过复杂，简化的方式就是创建更多的对象
    创建更多的对象意味着另一个层次的抽象
    总的来说
    如果一个地方的代码太过混乱臃肿
    考虑使用类来简化
     */
    static final List<Function<Double, Trash>> constructors =
        Arrays.asList(Aluminum::new, Paper::new, Glass::new);
    static final int SIZE = constructors.size();
    private static SplittableRandom random = new SplittableRandom();

    /**
     * 随机调用构造函数列表中的构造函数
     * 构造 Trash 对象
     * @return Trash 对象
     */
    public static Trash random() {
        return constructors
            .get(random.nextInt(SIZE))
            .apply(random.nextDouble());
    }
}
public class RecycleA {
    public static void main(String[] args) {
        List<Trash> bin =
            /*
            SimpleTrashFactory::random 也是一个函数对象
            虽然不是一个 Supplier<T>
            但是同样可以在 generate() 方法中使用
             */
            Stream.generate(SimpleTrashFactory::random)
                .limit(20)
                .collect(Collectors.toList());
        Bins bins = new Bins(bin);
        bins.show();
    }
}
