package com.angers.project.onjava8.polymorphism;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/13 09:14
 * @description : 多态-清理共享成员对象变量
 * 对共享的成员变量进行引用计数，计数为0，即不再被其它对象关联则可以执行清理操作
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing [] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };
        CommonUtils.printDivideLine("composings.Dispose()");
        Arrays.stream(composings).forEach(Composing::dispose);
        /* output:
        Creating Shared{refCount=0, id=0}
        Creating Composing{id=0}
        Shared{refCount=1, id=0}
        Creating Composing{id=1}
        Shared{refCount=2, id=0}
        Creating Composing{id=2}
        Shared{refCount=3, id=0}

        composings.Dispose()
        ------------------------------------------
        Dispose Composing{id=0}
        Shared{refCount=2, id=0}
        Dispose Composing{id=1}
        Shared{refCount=1, id=0}
        Dispose Composing{id=2}
        Shared{refCount=0, id=0}
        Dispose Shared{refCount=0, id=0}
         */
    }
}

class Shared {
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this );
    }
    public void addRef(){
        refCount ++;
        System.out.println(this.toString());
    }
    protected void dispose(){
        refCount -- ;
        System.out.println(this.toString());
        if (refCount == 0)
            System.out.println("Dispose " + this);
    }

    @Override
    public String toString() {
        return "Shared{" +
                "refCount=" + refCount +
                ", id=" + id +
                '}';
    }
}

class Composing {
    private Shared shared ;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        shared.addRef();
    }
    protected void dispose(){
        System.out.println("Dispose " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing{" +
                "id=" + id +
                '}';
    }
}