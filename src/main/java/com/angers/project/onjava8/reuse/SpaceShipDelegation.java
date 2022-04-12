package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 12:24
 * @description : 委托机制
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();
    public SpaceShipDelegation(String name) {
        this.name = name;
    }
    /*
    委托方法
    方法被转发到底层 control 对象，因此接口与继承相同
    然而，使用委托机制可以获得更多的控制权
    因为可以选择只暴露成员对象方法的子集
    而不是所有的方法
     */
    public void up(int velocity) {
        controls.up(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void backward(int velocity) {
        controls.backward(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }

    public static void main(String[] args) {
        SpaceShipDelegation spaceShip = new SpaceShipDelegation("Anger");
        spaceShip.forward(100);
    }
}
