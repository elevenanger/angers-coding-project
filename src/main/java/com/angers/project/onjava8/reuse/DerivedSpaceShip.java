package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 12:16
 * @description : 派生的宇宙飞船类
 * 尽管 DerivedSpaceShip 继承了 SpaceShipControls
 * 但是它并不是一种 SpaceShipControls
 * 告诉 DerivedSpaceShip forward
 * 更准确的来说是 DerivedSpaceShip 包含了 SpaceShipControls
 * 所有 SpaceShipControls 的方法通过 DerivedSpaceShip 暴露
 * 使用 delegation 可以解决这个问题
 */
public class DerivedSpaceShip extends SpaceShipControls{

    private String name;
    public DerivedSpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DerivedSpaceShip{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DerivedSpaceShip ship = new DerivedSpaceShip("Anger");
        ship.forward(100);
        System.out.println(ship.toString());
    }
}
