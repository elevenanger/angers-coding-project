package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 14:22
 * @description : 组合和继承结合使用
 */
public class PlaceSetting extends Custom{
    private Spoon sp ;
    private Fork frk;
    private Knife kn;
    private DinnerPlate dp;
    public PlaceSetting(int i) {
        super(i+1);
        sp = new Spoon(i+2);
        frk = new Fork( i+3);
        kn = new Knife(i+4);
        dp  = new DinnerPlate(i+5);
        System.out.println("PlaceSetting constructor " + i);
    }

    public static void main(String[] args) {
        PlaceSetting ps = new PlaceSetting(9);
    }
}

class Plate{
    public Plate(int i) {
        System.out.println("Plate constructor " + i);
    }
}

class DinnerPlate extends Plate {
    public DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate constructor " + i);
    }
}

class Utensil {
    public Utensil(int i) {
        System.out.println("Utensil constructor " + i);
    }
}

class Spoon extends Utensil {
    public Spoon(int i) {
        super(i);
        System.out.println("Spoon constructor " + i);
    }
}

class Fork extends Utensil {
    public Fork(int i) {
        super(i);
        System.out.println("Fork constructor " + i);
    }
}

class Knife extends Utensil {
    public Knife(int i) {
        super(i);
        System.out.println("Knife constructor " + i);
    }
}

class Custom {
    public Custom(int i) {
        System.out.println("Custom constructor " + i);
    }
}