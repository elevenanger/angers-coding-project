package com.angers.project.onjava8.annotations;

import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/13 08:45
 * @description :注解-密码工具—在方法中使用注解
 */
public class PasswordUtil {

    @UseCase(id = 93,desc = "密码至少包含一个数字")
    public boolean validatePassword(String passwd){
        return (passwd.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 94)
    public String encrypt(String passwd){
        return new StringBuilder(passwd).reverse().toString();
    }

    @UseCase(id = 95,desc = "新密码不能与旧密码重复")
    public boolean checkForNewPassword(List<String> forePass,String newPass){
        return !forePass.contains(newPass);
    }
}
