package com.angers.project.onjava8.reflection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/4 11:22
 * @description : 反射-工厂类
 */
public class RegisteredFactories {
    public static void main(String[] args) {
        Stream.generate(new Part())
                .limit(10)
                .forEach(System.out::println);
    }
}
class Part implements Supplier<Part> {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    /*
    Part 工厂类原型对象
    基类 Part 实现 Supplier<Part> 接口
    Part 的派生类做为工厂的对象原型
    通过其创建各个子类的对象
    不是所有的子类都需要创建原型
    Part 和 Belt 起到分类器的作用
    不需要为此创建实例对象
    只需要实例化它们的子类
     */
    static List<Supplier<? extends Part>> prototypes =
            Arrays.asList(
                    new FuelFilter(),
                    new AirFilter(),
                    new OilFilter(),
                    new CabinFilter(),
                    new FanBelt(),
                    new GeneratorBelt(),
                    new PowerSteeringBelt()
            );
    private static Random random = new Random(93);

    /**
     * 工厂方法
     * 通过随机数，随机获取原型对象，调用 Supplier.get() 方法产生对象实例
     * @return 随机的子类对象
     */
    @Override
    public Part get() {
        int n = random.nextInt(prototypes.size());
        return prototypes.get(n).get();
    }
}

class Filter extends Part {}
class FuelFilter extends Filter {
    @Override
    public FuelFilter get() {
        return new FuelFilter();
    }
}
class AirFilter extends Filter {
    @Override
    public AirFilter get() {
        return new AirFilter();
    }
}
class CabinFilter extends Filter{
    @Override
    public CabinFilter get() {
        return new CabinFilter();
    }
}
class OilFilter extends Filter {
    @Override
    public OilFilter get() {
        return new OilFilter();
    }
}

class Belt extends Part {}
class FanBelt extends Belt {
    @Override
    public FanBelt get() {
        return new FanBelt();
    }
}
class GeneratorBelt extends Belt {
    @Override
    public GeneratorBelt get() {
        return new GeneratorBelt();
    }
}
class PowerSteeringBelt extends Belt {
    @Override
    public PowerSteeringBelt get() {
        return new PowerSteeringBelt();
    }
}