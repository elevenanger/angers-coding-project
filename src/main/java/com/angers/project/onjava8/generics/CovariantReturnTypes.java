package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 19:15
 * @description : 协变参数类型-方法参数类型因子类而已
 */
public class CovariantReturnTypes {
    void test(DerivedGetter dg){
        Derived derived = dg.get();
    }
}

class Base {}

class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    @Override
    Derived get();
}