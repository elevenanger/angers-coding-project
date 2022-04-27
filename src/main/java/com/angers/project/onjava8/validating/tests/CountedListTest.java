package com.angers.project.onjava8.validating.tests;

import com.angers.project.onjava8.validating.CountedList;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author : liuanglin
 * @date : 2022/4/26 08:29
 * @description : 验证- 使用单元测试用例验证 CountedList 的方法
 */
public class CountedListTest {
    private CountedList list;

    /*
    @BeforeAll 注解在当前单元测试类中，测试之前执行
    @AfterAll 在测试完全结束后执行
    两个方法都必须是 static 方法
     */
    @BeforeAll
    static void beforeAllMessage(){
        System.out.println(">>> starting counted list test <<<");
    }

    @AfterAll
    static void afterAllMessage(){
        System.out.println(">>> finished counted list test <<<");
    }

    /*
    @BeforeEach 在每个测试用例之前执行
    一般用于进行初始化的操作
     */
    @BeforeEach
    public void initialize(){
        list = new CountedList();
        System.out.println("set up for list : " + list.getId());
        for (int i = 0; i <3 ; i++) {
            list.add(Integer.toString(i));
        }
    }

    /*
    在每个测试用例执行完成之后执行此方法
    可以用于资源清理等操作
     */
    @AfterEach
    public void cleanUp(){
        System.out.println("Cleaning up : " + list.getId());
    }

    @Test
    public void insert(){
        System.out.println("Running testInsert");
        assertEquals(list.size(),3);
        list.add(1,"insert");
        assertEquals(list.size(),4);
        assertEquals(list.get(1),"insert");
    }

    @Test
    public void replace(){
        System.out.println("Running testReplace()");
        assertEquals(list.size(),3);
        list.set(1,"replace");
        assertEquals(list.size(),3);
        assertEquals(list.get(1),"replace");
    }

    private void compare(List<String> list ,String [] strings){
        assertArrayEquals(list.toArray(new String[0]),strings);
    }

    @Test
    public void order() {
        System.out.println("running testOrder()");
        compare(list,new String [] {"0","1","2"});
    }

    @Test
    public void remove(){
        System.out.println("Running testRemove()");
        assertEquals(list.size(),3);
        list.remove(1);
        assertEquals(list.size(),2);
        compare(list,new String[]{"0","2"});
    }

    @Test
    public void addAll(){
        System.out.println("Running addAll()");
        list.addAll(Arrays.asList("hello","jUnit"));
        assertEquals(list.size(),5);
        compare(list,new String[]{"0","1","2","hello","jUnit"});
    }

}
