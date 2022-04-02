package com.angers.project.corejava.inner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayAlg {

    /*
     内部类
     double数值对
     内部类包含对外部对象的引用，如果不需要该引用，则可以将内部类定义为 static
     */
    public static class Pair {
        /*
        最大值
         */
        private final double firstValue;
        /*
        最小值
         */
        private final double secondValue;

        /**
         * 构造函数
         * @param firstValue 第一个数
         * @param secondValue 第二个数
         */
        public Pair(double firstValue,double secondValue){
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        /**
         * 第一个值
         * @return 第一个数
         */
        public double getFirstValue(){
            return firstValue;
        }

        /**
         * 第二个值
         * @return 第二个数
         */
        public double getSecondValue(){
            return secondValue;
        }
    }

    /**
     * 获取数组中的最大和最小值
     * @param values double 数组
     * @return 数值对
     */
    public static Pair minMax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v:values){
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min,max);
    }

    public static void main(String [] args){
        double [] values = {1.22,2.33,4.22,-10.4};
        Pair pair = minMax(values);
        log.info("minValue: "+ pair.getFirstValue());
        log.info("maxValue: "+ pair.getSecondValue());
    }
}
