package com.angers.project.onjava8.compare;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/6/2 11:02
 * @description :
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type){
        try {
            Constructor<T> ghog =
                    type.getConstructor(int.class);
            Map<Groundhog,Prediction> map =
                    IntStream.range(0,10)
                            .mapToObj( i -> {
                                try {
                                    return ghog.newInstance(i);
                                }catch (Exception e){
                                    throw new RuntimeException(e);
                                }
                            }).collect(Collectors.toMap(
                                    Function.identity(),
                                    gh -> new Prediction()));
            map.forEach((k,v) -> System.out.println( k + " : " + v));
            Groundhog gh = ghog.newInstance(3);
            System.out.println("looking up Prediction for " + gh);
            if (map.containsKey(gh)) System.out.println(map.get(gh));
            else System.out.println("Key not found " + gh);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        detectSpring(Groundhog.class);
        /*
        Groundhog{number=5} : Prediction{}six more weeks for winter
        Groundhog{number=9} : Prediction{}early spring
        Groundhog{number=3} : Prediction{}six more weeks for winter
        Groundhog{number=1} : Prediction{}early spring
        Groundhog{number=8} : Prediction{}early spring
        Groundhog{number=6} : Prediction{}six more weeks for winter
`       Groundhog{number=4} : Prediction{}early spring
        Groundhog{number=0} : Prediction{}early spring
        Groundhog{number=2} : Prediction{}early spring
        Groundhog{number=7} : Prediction{}early spring
        looking up Prediction for Groundhog{number=3}
        Key not found Groundhog{number=3}

        Groundhog 直接继承 Object
        hashCode() 方法默认是使用对象的内存地址
        新的 Groundhog(3) 实例的内存地址和 map 中的 Groundhog(3) 的内存地址不一致
        导致查找不到对应的元素
        需要对 hashCode() 方法进行重写
        使用重写了hashCode() 和 equals() 方法的类进行测试可以输出正确的结果
         */
        detectSpring(Groundhog2.class);
    }
}
