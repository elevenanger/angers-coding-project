package com.angers.project.onjava8.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/4/30 16:58
 * @description : 字符串-使用StringBuilder进行字符串拼接
 * 处于性能考虑，使用 StringBuilder 进行字符串拼接效率更高
 */
public class ConcatenationWithStringBuilder {
    /**
     * 隐式地使用 StringBuilder 进行字符串拼接
     * @param strings 字符串数组
     * @return 拼接后的字符串
     */
    String implicit(String ... strings){
        String result = "";
        for (String s: strings) {
            result += s;
        }
        return result;
    }

    /**
     * 显示地使用 StringBuilder 进行字符串拼接
     * @param strings 字符串数组
     * @return 拼接后的字符串
     */
    String explicit(String ... strings){
        // Collectors.join 使用了 StringBuilder
        return Arrays.stream(strings)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String [] strings = {"we","are","the","world"};
        ConcatenationWithStringBuilder builder = new ConcatenationWithStringBuilder();
        System.out.println(builder.implicit(strings));
        System.out.println(builder.explicit(strings));
    }
}
