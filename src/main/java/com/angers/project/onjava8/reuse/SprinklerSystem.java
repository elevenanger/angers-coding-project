package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 09:34
 * @description : 代码重用-编排
 */
public class SprinklerSystem{
    private String valve1;
    private String valve2;
    private String valve3;
    private String valve4;
    private  WaterSource waterSource = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString(){
        return
                "valve1 = " +valve1 + " " +
                "valve2 = " +valve2 + " " +
                "valve3 = " +valve3 + " " +
                "valve4 = " +valve4 + " \n" +
                " i = " + i + " " +
                " f = " + f + " " +
                " waterSource = " + waterSource;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);

        /* output
        WaterSource
        valve1 = null valve2 = null valve3 = null valve4 = null
        i = 0  f = 0.0  waterSource = WaterSource Constructed.
         */
    }
}

class WaterSource {
    private String s;
    WaterSource(){
        System.out.println("WaterSource");
        s = "WaterSource Constructed.";
    }
    @Override
    public String toString(){
        return s;
    }
}
