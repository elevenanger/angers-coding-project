package com.angers.project.onjava8.compare;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/4 17:35
 * @description : Collections 工具类中 api 的用法
 */
public class Utilities {
    static List<String> list = Arrays.asList(
            "one Two three Four five six one".split(" "));

    public static void main(String[] args) {
        System.out.println(list);
        System.out.println("'list' disjoint (Four) ? : " +
                // 如果两个集合没有交集则返回 true
                Collections.disjoint(list,
                        // 创建一个仅包含一个对象的不可变 list
                        Collections.singletonList("Four")));
        /*
        min max 按照自然顺序返回集合中最小和和最大的元素
        集合中的元素需要使用 Comparable 接口
         */
        System.out.println("max : " + Collections.max(list));
        System.out.println("min : " + Collections.min(list));
        /*
        String.CASE_INSENSITIVE_ORDER
        使用指定的 Comparator 进行元素排序
        输出 min max
         */
        System.out.println("max w/ comparator : " +
                Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator : " +
                Collections.min(list,String.CASE_INSENSITIVE_ORDER));
        List<String> subList =
                Arrays.asList(("Four five six").split(" "));
        // subList 首次出现在 list 中的起始位置
        System.out.println("indexOfSublist : " +
                Collections.indexOfSubList(list,subList));
        // subList 最后一次出现在 list 中的起始位置
        System.out.println("lastIndexOfSublist : " +
                Collections.lastIndexOfSubList(list,subList));
        // 将集合中的某一个元素全部替换为另一个指定的元素
        Collections.replaceAll(list,"one","yo");
        System.out.println("replaceAll : " + list);
        // 颠倒 list 中所有元素的顺序
        Collections.reverse(list);
        System.out.println("reverse : " + list);
        // 旋转 list 将指定位置之后的元素替换到当前位置
        Collections.rotate(list,3);
        System.out.println("rotate : " + list);
        List<String> source =
                Arrays.asList("in the matrix".split(" "));
        // 将一个 list 拷贝到另一个 list
        Collections.copy(list,source);
        System.out.println("copy : " + list);
        // 交换 list 中两个元素的位置
        Collections.swap(list,0,list.size() - 1);
        System.out.println("swap : " + list);
        // 打乱 list 中元素的顺序
        Collections.shuffle(list,new Random(93));
        System.out.println("shuffled : " + list);
        // 使用一个对象填充 list
        Collections.fill(list,"pop");
        System.out.println("fill : " + list);
        // 某个元素出现的次数
        System.out.println("frequency of 'pop' : " +
                Collections.frequency(list,"pop"));
        // 创建一个全部由指定对象组成的指定长度的集合
        List<String> dups =
                Collections.nCopies(3,"snaps");
        System.out.println("dups : " + dups);
        System.out.println("'list' disjoint 'dups' ? : " +
                Collections.disjoint(list,dups));
        Enumeration<String> enumeration = Collections.enumeration(dups);
        Vector<String> vector = new Vector<>();
        while (enumeration.hasMoreElements())
            vector.addElement(enumeration.nextElement());
        ArrayList<String> arrayList = Collections.list(vector.elements());
        System.out.println("arrayList : " + arrayList);
    }
}
