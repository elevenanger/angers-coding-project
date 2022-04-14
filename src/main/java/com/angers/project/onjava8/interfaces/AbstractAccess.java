package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 14:45
 * @description : 抽象类的访问
 */
abstract class AbstractAccess {
    private void m1(){}
    //  private void m1a(); 不合法，抽象方法不能为 private
    protected void m2(){}
    protected abstract void m2a();
    void m3(){}
    abstract void m3a();
    public void m4(){}
    public abstract void m4a();
}
