package com.angers.project.onjava8.functional;

import java.util.Comparator;
import java.util.function.*;

/**
 * @author : liuanglin
 * @date : 2022/4/21 09:14
 * @description :函数-类函数接口
 */
public class ClassFunctions {
    static AA f1() {
        return new AA();
    }
    static int f2(AA aa1, AA aa2){
        return 1;
    }
    static void f3(AA aa){}
    static void f4(AA aa ,BB bb){}
    static CC f5(AA aa){return  new CC();}
    static CC f6(AA aa ,BB bb){return new CC();}
    static boolean f7(AA aa){return true;};
    static boolean f8(AA aa ,BB bb) {return true;}
    static AA f9(AA aa){return new AA();}
    static AA f10(AA aa1,AA aa2){return new AA();}

    public static void main(String[] args) {
        Supplier<AA> s = ClassFunctions::f1;
        Comparator<AA> c = ClassFunctions::f2;
        System.out.println(c.compare(new AA(),new AA()));
        Consumer<AA> consumer = ClassFunctions::f3;
        consumer.accept(new AA());
        BiConsumer<AA,BB> biConsumer = ClassFunctions::f4;
        biConsumer.accept(new AA(),new BB());
        Function<AA,CC> function = ClassFunctions::f5;
        CC cc = function.apply(new AA());
        BiFunction<AA,BB,CC> biFunction = ClassFunctions::f6;
        CC cc1 = biFunction.apply(new AA(),new BB());
        Predicate<AA> predicate = ClassFunctions::f7;
        boolean result = predicate.test(new AA());
        BiPredicate<AA,BB> biPredicate = ClassFunctions::f8;
        result = biPredicate.test(new AA(),new BB());
        UnaryOperator<AA> unaryOperator = ClassFunctions::f9;
        AA aa = unaryOperator.apply(new AA());
        BinaryOperator<AA> binaryOperator = ClassFunctions::f10;
        aa = binaryOperator.apply(new AA(),new AA());
    }
}

class AA {}
class BB {}
class CC {}
