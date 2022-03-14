package com.angers.project.inheritance;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class LambdaExpressions {

    public  static void main(String [] args) {

        String [] words = new String [] {"actions","bounds","availability"};

        /*
        lambda 表达式的组成：参数变量，-> 箭头,表达式
        在 java 中，lambda 表达式的唯一用途就是将其转换成函数式的接口
        Comparator<String> stringComparator = (String fir, String sec) -> fir.length() - sec.length();
        使用 lambda 表达式实现 Comparator<? super T> c
        由于  words 的元素类型是 String
        (fir,sec) 的参数类型则无需声明，和 words 元素类型一样都是 String
         */
        Arrays.sort(words,(fir,sec) -> fir.length()-sec.length());
        for (String word : words) {
            log.info(word);
        }

        ArrayList<String> wordsArrayList = new ArrayList<>();
        wordsArrayList.add("dance");
        wordsArrayList.add("clever");
        wordsArrayList.add("");

        /*
        predicate 接口，lambda函数
         */
        wordsArrayList.removeIf(Objects::isNull);
        for (String word : wordsArrayList) {
            log.info(word);
        }

    }
}