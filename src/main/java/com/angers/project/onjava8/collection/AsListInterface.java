package com.angers.project.onjava8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/4/18 16:25
 */
public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(),new Crusty(),new Slush());
        /*
        因为 Array 的长度数是定的
        新增元素会报错
        snow1.add(new Heavy());
         */
        List<Snow> snow2 = new ArrayList<>();
        Collections.addAll(snow2,new Light(),new Crusty(),new Slush());
        snow2.add(new Powder());
        // 显示声明参数类型 Arrays.<Snow>asList
        List<Snow> snow3 = Arrays.<Snow>asList(new Powder(),new Slush(),new Crusty());
    }
}

class Snow{}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Slush extends Snow {}
class Crusty extends Snow {}
