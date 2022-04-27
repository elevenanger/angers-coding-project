package com.angers.project.onjava8.validating;

import java.util.function.Consumer;
import static com.google.common.base.Preconditions.*;

/**
 * @author : liuanglin
 * @date : 2022/4/26 18:26
 * @description : 校验-Guava中的 preconditions
 */
public class GuavaPreconditions {
    static void test(Consumer<String> c , String s){
        try {
            System.out.println(s);
            c.accept(s);
            System.out.println("Success");
        }catch (Exception e){
            String type = e.getClass().getSimpleName();
            String message = e.getMessage();
            System.out.println(type +
                    (message == null?"":": " + message));
        }
    }

    public static void main(String[] args) {
        // 检查是否为空，为空则抛出异常信息,不为空则返回检查对象
        test(s -> s = checkNotNull(s),"x");
        test(s -> s = checkNotNull(s),null);
        // 自定义异常信息
        test(s -> s = checkNotNull(s,"s was null"),null);
        test(s -> s = checkNotNull(s,"s was null ,%s %s ","arg2","arg3"),null);
        // 参数检查,自定义检查逻辑
        test(s -> checkArgument(s == "arg"),"arg");
        test(s -> checkArgument(s == "arg"),"x");
        test(s -> checkArgument(s == "arg"),null);
        test(s -> checkArgument(s == "arg","errMsg"),null);
        test(s -> checkArgument(s == "arg","errMsg","errMsg2"),null);
        // 对象状态信息检查，自定义检查逻辑
        test(s -> checkState(s.length() > 6),"hahahaha");
        test(s -> checkState(s.length() > 6),"haha");
        test(s -> checkState(s.length() > 6),null);
        // 检查元素是否存在
        test(s -> checkElementIndex(6,s.length()),"anger");
        test(s -> checkElementIndex(6,s.length()),"angeryMan");
        test(s -> checkElementIndex(6,s.length()),null);
        test(s -> checkPositionIndex(6,s.length()),"anger");
        test(s -> checkPositionIndex(6,s.length()),"angerPerson");
        test(s -> checkPositionIndex(6,s.length()),null);
        test(s -> checkPositionIndexes(0,6,s.length()),"anger");
        test(s -> checkPositionIndexes(0,6,s.length()),"angerPerson");
    }
}
