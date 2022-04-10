package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/9 16:05
 * @description : 使用枚举值作为类的成员变量
 */
public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree){
        this.degree = degree;
    }

    /*
    switch 是从一组有限可能中进行选择，契合枚举的特性
     */
    public void describe(){
        System.out.println("This burrito is ");
        switch (degree) {
            case NOT:
                System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot.");
                break;
            case HOT:
            case FLAMING:
            default:
                System.out.println("too hot.");
        }
    }

    public static void main(String[] args) {
        Burrito
                plain = new Burrito(Spiciness.NOT),
                middle = new Burrito(Spiciness.MILD),
                hot = new Burrito(Spiciness.HOT);
        plain.describe();
        middle.describe();
        hot.describe();
    }
}
