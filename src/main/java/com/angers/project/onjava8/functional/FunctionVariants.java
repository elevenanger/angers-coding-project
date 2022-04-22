package com.angers.project.onjava8.functional;

import java.util.function.*;

/**
 * @author : liuanglin
 * @date : 2022/4/21 08:39
 * @description :
 */
public class FunctionVariants {
    /*
    Function<T, R>
    T 输入类型对象
    R 输出类型对象

    lambda 表达式产生匹配接口方法签名的代码
     */
    static Function<Foo,Bar> f1 = Bar::new;
    // IntFunction<R> 输入 int ，输出 <R> - IBaz
    static IntFunction<IBaz> f2 = IBaz::new;
    static LongFunction<LBaz> f3 = LBaz::new;
    static DoubleFunction<DBaz> f4 = DBaz::new;
    // ToIntFunction<T> 输入 <T> 输出 int
    static ToIntFunction<IBaz> f5 = i -> i.i;
    static ToLongFunction<LBaz> f6 = l -> l.l;
    static ToDoubleFunction<DBaz> f7 = d -> d.d;
    // 基元类型转换函数接口
    static IntToLongFunction f8 = i -> i;
    static IntToDoubleFunction f9 = i -> i;
    static LongToIntFunction f10 = l -> (int) l;
    static LongToDoubleFunction f11 = i -> i;
    static DoubleToIntFunction f12 = d -> (int) d;
    static DoubleToLongFunction f13 = d -> (long) d;

    public static void main(String[] args) {
        Bar bar = f1.apply(new Foo());
        IBaz iBaz = f2.apply(1);
        LBaz lBaz = f3.apply(1L);
        DBaz dBaz = f4.apply(1.0d);
        int i = f5.applyAsInt(new IBaz(2));
        long l = f6.applyAsLong(new LBaz(2L));
        double d = f7.applyAsDouble(new DBaz(2.0d));
        long i2 = f8.applyAsLong(3);
        double d2 = f9.applyAsDouble(3);
        int i3 = f10.applyAsInt(4L);
        double d3 = f11.applyAsDouble(5L);
        int i4 = f12.applyAsInt(3.0d);
        long l2 = f13.applyAsLong(4.0d);
    }
}

class Foo{}

class Bar {
    Foo f;

    public Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;
    public IBaz(int i) {
        this.i = i;
    }
}
class LBaz{
    long l;

    public LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    public DBaz(double d) {
        this.d = d;
    }
}