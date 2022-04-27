package com.angers.project.onjava8.validating.tests;
import com.angers.project.onjava8.validating.CircularQueue;
import com.angers.project.onjava8.validating.CircularQueueException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : liuanglin
 * @date : 2022/4/26 16:19
 * @description : 验证-使用 Junit 对 CircularQueue 进行测试
 */
public class CircularQueueTest {
    private CircularQueue queue = new CircularQueue(10);
    private int i = 0;
    /**
     * 初始化操作
     */
    @BeforeEach
    public void initialize(){
        // 为队列塞入五个元素
        while (i < 5)
            queue.put(String.valueOf(i++));
    }
    /*
    检查队列是否已满，打印队列
     */
    private void showFullness(){
        assertTrue(queue.full());
        assertFalse(queue.empty());
        System.out.println(queue.toString());
    }
    // 查看队列是否为空，打印空队列
    private void showEmptiness(){
        assertFalse(queue.full());
        assertTrue(queue.empty());
        System.out.println(queue.toString());
    }
    /**
     * 测试队列是否为空
     */
    @Test
    public void full(){
        System.out.println("test full");
        System.out.println(queue.toString());
        System.out.println(queue.get());
        System.out.println(queue.get());
        // 为队列新增元素，直到队列满
        while (!queue.full()){
            queue.put(Integer.toString(i++));
        }
        String msg = "";
        try {
            queue.put("");
        }catch (CircularQueueException e){
            msg = e.getMessage();
            System.out.println(msg);
        }
        // 断言异常信息
        assertEquals(msg,"full queue");
        showFullness();
    }
    @Test
    public void empty(){
        System.out.println("test empty");
        // 取出队列中的元素，直到队列为空
        while (!queue.empty())
            System.out.println(queue.get());
        String msg = "";
        try {
            queue.get();
        }catch (CircularQueueException e){
            msg = e.getMessage();
            System.out.println(msg);
        }
        assertEquals(msg,"queue is empty!");
    }
    // 测试往队列中插入空值
    @Test
    public void nullPut(){
        System.out.println("test null put");
        String msg = "";
        try {
            queue.put(null);
        }catch (CircularQueueException e){
            msg = e.getMessage();
            System.out.println(msg);
        }
        assertEquals(msg,"put null item");
    }
    // 测试队列功能
    @Test
    public void circularity(){
        System.out.println("test circularity");
        while (!queue.full())
            queue.put(Integer.toString(i++));
        showFullness();
        assertTrue(queue.isWrapped());
        while (!queue.empty())
            System.out.println(queue.get());
        showEmptiness();
        while (!queue.full())
            queue.put(Integer.toString(i++));
        showFullness();
        while (!queue.empty())
            System.out.println(queue.get());
        showEmptiness();
    }
}