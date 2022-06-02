package com.angers.project.onjava8.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/6/2 17:01
 * @description : 填充 List
 */
class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "StringAddress{" +
                "s='" + s + '\'' +
                '}';
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Anger")));
        System.out.println(list);
        Collections.fill(list,
                new StringAddress("Eleven"));
        System.out.println(list);
    }
}
