package com.angers.project.onjava8.validating.tests;

import com.angers.project.onjava8.common.CommonUtils;
import com.angers.project.onjava8.validating.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/27 09:21
 * @description :验证-测试驱动开发-使用 Junit5 的动态生成测试用例的特性进行单元测试
 */
public class DynamicStringInvertTests {
    static final String SUC = "success";
    static final String FAIL = "fail";
    static Random random = new Random();
    /**
     * 生成动态测试流
     * @param id 测试用例 ID
     * @param test 测试用例
     * @return 测试用例流
     */
    Stream<DynamicTest> testVersion(String id, Function<StringInverter,String> test){
        // 对于每种类型，各生成一个对象
        List<StringInverter> versions= Arrays.asList(
                new Inverter1(),
                new Inverter2(),
                new Inverter3(),
                new Inverter4()
        );
        // 生成动态测试用例流
        return DynamicTest.stream(versions.iterator(), // 测试对象迭代器
                inverter -> inverter.getClass().getSimpleName(), // 描述测试的用例
                inverter -> { // 执行测试用例
                    System.out.println(inverter.getClass().getSimpleName() + ":" +id);
                    try {
                        if (test.apply(inverter)!=FAIL)
                            System.out.println("Success");
                    }catch (Exception |Error e){
                        System.out.println(
                                "Exception:" + e.getMessage()
                        );
                    }
                });
    }
    /**
     * 判断两个字符串是否相等
     * @param lVal 第一个字符创
     * @param rVal 第二个字符串
     * @return 比较结果
     */
    String isEqual(String lVal,String rVal){
        if (lVal.equals(rVal))
            return "success";
        System.out.println("Fail isEqual() : " + lVal + " != " + rVal);
        return FAIL;
    }
    /**
     * 测试启动信息
     */
    @BeforeAll
    static void startMsg(){
        CommonUtils.
                printDivide("Starting DynamicStringInvertTests");
    }
    /*
    测试结束信息
     */
    @AfterAll
    static void endMsg(){
        CommonUtils.
                printDivide("Finished DynamicStringInvertTests");
    }
    /**
     * 测试用例工厂方法
     * @return 测试用例流
     */
    @TestFactory
    Stream<DynamicTest> basicInversion1(){
        String in = "Exit, Pursued by a Bear.";
        String out = "eXIT, pURSUED BY A bEAR.";
        return testVersion(
                "Basic inversion (should succeed)",
                inverter -> isEqual(inverter.invert(in),out)
        );
    }
    @TestFactory
    Stream<DynamicTest> basicInversion2(){
        return testVersion("Basic inversion2 should fail",
        inverter -> isEqual(inverter.invert("X"),"X" ));
    }
    @TestFactory
    Stream<DynamicTest> disallowedCharacters(){
        String disallowed = ";-_()*&^%$#@!~`0123456789";
        return testVersion(
                "Disallowed characters",
                stringInverter -> {
                    String result = disallowed.chars()
                            .mapToObj(c ->{
                                        String cc = Character.toString((char) c);
                                        try {
                                            // 执行 invert 方法
                                            stringInverter.invert(cc);
                                            // 成功则跳过该字符
                                            return "";
                                        }catch (RuntimeException e){
                                            // 方法执行失败则返回字符
                                            return cc;
                                        }
                                    }).collect(Collectors.joining("")); // 将不符合的字符拼接成字符串
                    if (result.length() == 0) return SUC; // 不符合字符长度为 0 符合预期的测试结果
                    System.out.println("Bad characters " + result); // 存在不符合的字符，打印不符合的字符，测试失败
                    return FAIL;
                }
        );
    }
    @TestFactory
    Stream<DynamicTest> allowedCharacters(){
        String lowcase = "abcdefghijklmnopqrstuvwxyz ,.";
        String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
        return testVersion(
                "Allow characters (should secceed) ",
                stringInverter -> {
                    assertEquals(stringInverter.invert(lowcase),upcase);
                    assertEquals(stringInverter.invert(upcase),lowcase);
                    return SUC;
                }
        );
    }
    @TestFactory
    Stream<DynamicTest> lengthNoGreaterThan(){
        String str = random.ints(0,9)
                .limit(40)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
        assertTrue(str.length()>30);
        return testVersion("length must less than 31",
                stringInverter -> stringInverter.invert(str));
    }
    @TestFactory
    Stream<DynamicTest> lengthLessThan(){
        String str = random.ints(0,9)
                .limit(20)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
        System.out.println(str);
        assertTrue(str.length() < 31);
        return testVersion("length must less than 31",
                stringInverter -> stringInverter.invert(str)
                );
    }
}