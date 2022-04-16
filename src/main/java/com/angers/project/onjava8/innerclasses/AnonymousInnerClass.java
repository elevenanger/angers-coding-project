package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 10:52
 * @description : 内部类-匿名内部类
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
        System.out.println(contents.value());
        Parcel7b parcel7b = new Parcel7b();
        Contents contents1 = parcel7b.contents();
        System.out.println(contents1.value());
    }
}
class Parcel7 {
    public Contents contents() {
        // 使用匿名内部类构建接口对象，返回其引用
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }
}

class Parcel7b {
    private class MyContents implements Contents {
        private int i = 1;
        @Override
        public int value() {
            return i;
        }
    }
    public Contents contents(){
        return new MyContents();
    }
}