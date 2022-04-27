package com.angers.project.onjava8.validating;
import com.google.common.base.*;
import static com.google.common.base.Verify.*;

/**
 * @author : liuanglin
 * @date : 2022/4/26 10:58
 * @description : 验证-使用 Guava 的断言
 */
public class GuavaAssertions {
    public static void main(String[] args) {
        /*
        使用 Guava 的 verify() 和 verifyNotNull() 方法设置断言
         */
        verify(2+2 == 4);
        try {
            verify(1+2 == 4);
        }catch (VerifyException e){
            System.out.println(e.getMessage());
        }
        try {
            verify(1+2 == 4,"bad verify");
        }catch (VerifyException exception){
            System.out.println(exception.getLocalizedMessage());
        }
        String s = "";
        verifyNotNull(s);
        s = null;
        try {
            verifyNotNull(s);
        }catch (VerifyException e){
            System.out.println(e.getLocalizedMessage()); // verifyNotNull() 方法内置了错误信息
        }
    }
}
