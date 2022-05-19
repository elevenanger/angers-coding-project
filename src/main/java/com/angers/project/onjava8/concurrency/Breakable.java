package com.angers.project.onjava8.concurrency;

/**
 * @author : liuanglin
 * @date : 2022/5/18 15:23
 * @description : 并发- CompletableFuture 缓冲异常
 * 与 CompletableFuture 在处理链中包装对象一样
 * 它也会缓冲异常
 * 在处理过程中异常不会暴露出来
 * 只有从结果中提取出来
 */
public class Breakable {
    String id;
    private int failCount;

    public Breakable(String id, int failCount) {
        this.id = id;
        this.failCount = failCount;
    }

    @Override
    public String toString() {
        return "Breakable{" +
                "id='" + id + '\'' +
                ", failCount=" + failCount +
                '}';
    }

    /**
     * 每次执行 work() 方法
     * breakable 对象的 failCount-1
     * 如果 breakable 对象的 failCount 是一个正数
     * 当减少到 0 则抛出异常
     * @param breakable 对象
     * @return failCount - 1 后的 breakable 对象
     */
    public static Breakable work(Breakable breakable){
        if (--breakable.failCount == 0) {
            System.out.println("Throwing Exception for " + breakable.id + " ");
            throw new RuntimeException("Breakable_" + breakable.id + " Failed.");
        }
        System.out.println(breakable);
        return breakable;
    }
}
