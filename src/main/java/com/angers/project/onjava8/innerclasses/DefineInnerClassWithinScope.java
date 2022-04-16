package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 10:15
 * @description : 在代码片段中定义内部类
 * 实现特定的逻辑，但是对外隐藏该类
 */
public class DefineInnerClassWithinScope {
    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.internalTracking(true);
        System.out.println(parcel6.getTrackTo());
        parcel6.internalTracking(false);
        System.out.println(parcel6.getTrackTo());
    }
}

class Parcel6 {
    private static final String OUTER_STATION = "outer";
    /*
    目标地址
     */
    String trackTo;
    public String getTrackTo() {
        return trackTo;
    }

    /**
     * 判断是对外还是对外，设置目标地址
     * @param b true 对内 false 对外
     */
    public void internalTracking(Boolean b){
        if (b){
            /*
            InnerStation 定义于条件代码分支中
            这不代表该类是依据条件创建的
            然而，它无法在改条件分支语句之外访问
            除此以外，它和常规的类没有区别
             */
            class InnerStation implements Destination {
                private static final String INNER_STATION = "inner";
                final String innerStation;
                public InnerStation() {
                    this.innerStation = INNER_STATION;
                }
                public String getInnerStation() {
                    return innerStation;
                }
                @Override
                public void readLabel() {
                    System.out.println(getClass().getSimpleName() + " " + getInnerStation());
                }
            }
            InnerStation innerStation = new InnerStation();
            this.trackTo = innerStation.getInnerStation();
        } else {
            this.trackTo = OUTER_STATION;
        }
    }
}
