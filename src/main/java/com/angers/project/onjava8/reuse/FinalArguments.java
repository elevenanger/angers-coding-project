package com.angers.project.onjava8.reuse;

import java.time.LocalDateTime;

/**
 * @author : liuanglin
 * @date : 2022/4/12 09:47
 * @description : final 修饰方法参数使用
 */
public class FinalArguments {
    // 将对象引用参数定义为 final 则无法修改其引用对象
    void with(final Gizmo gizmo){
        // gizmo = new Gizmo(); not ok , gizmo is final
    }
    void without(Gizmo gizmo){
        gizmo = new Gizmo(); // ok
        gizmo.spin();
    }
    // 将基元类型参数定义为 final 则只可以读取其值，不能修改其值
    int g(final int i){
        return i+1;
        // return i ++ ; not ok！
    }

    public static void main(String[] args) {
        FinalArguments finalArguments = new FinalArguments();
        finalArguments.with(null);
        finalArguments.without(null);
    }
}

class Gizmo {
    public void spin(){
        System.out.println(LocalDateTime.now());
    }
}
