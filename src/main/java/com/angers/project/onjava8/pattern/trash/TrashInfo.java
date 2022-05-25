package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 16:15
 * @description : 垃圾信息-创建更多的对象来进行抽象
 * 构建一个 Trash 对象未来可能需要更多的信息
 * 构造的参数是变化的
 * 将这些信息封装在 TrashInfo 中隐藏这些变化
 * TrashInfo 包括构造 Trash 对象所需要的所有信息
 * TrashInfo 对象的唯一职责是保存以及传输信息
 * 所以它也被称为 信使对象 或者 数据传输对象
 * 它通常是不可变的
 * 所有的域都是 final 的
 * 如果需要更多的信息来创建 Trash 对象
 * 不需要改变工厂方法参数
 * 通过以下方式来修改 TrashInfo ：
 * 1、直接在 TrashInfo 中新增域
 * 2、新的构造函数
 * 3、创建子类
 */
public class TrashInfo {
    // Trash 类型
    public final String type;
    // 构造 Trash 对象需要的参数数据
    public final double data;

    public TrashInfo(String type, double data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return "TrashInfo{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
