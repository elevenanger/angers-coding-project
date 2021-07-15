package com.angers.project;

import com.angers.project.dao.UserInfoMapper;
import com.angers.project.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class UserInfoTester extends Tester{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void test(){
        log.info("userinfo测试开发。。。");
        List<UserInfo> userInfoList = userInfoMapper.selectList(null);
        for (UserInfo userInfo:userInfoList){
            log.info(userInfo.toString());
        }
    }

}
