package com.angers.project.onjava8.hiding;

/**
 * @author : liuanglin
 * @date : 2022/4/10 16:32
 * @description : 联动 Pie 无修饰符修饰的 class
 */
class Cake {
    public static void main(String[] args) {
        /*
        Cake 类可以创建 Pie 对象并且调用 Pie.f() 方法
        它们在 Cake.java 中可用的原因是它们在同一个目录中如果没有明确的包名（这里是声明了包名的）
        Java 将此类文件视为该目录“默认包”的隐含一部分
        因此它们提供对该目录中所有其他文件的包访问
         */
        Pie pie = new Pie();
        pie.f();
    }
}
