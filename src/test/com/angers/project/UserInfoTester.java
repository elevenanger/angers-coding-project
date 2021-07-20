package com.angers.project;

import com.angers.project.entity.UserInfo;
import com.angers.project.mapper.UserInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class UserInfoTester extends Tester{

    @Autowired
    private UserInfoMapper userInfoMapper;

    private static String mobileNo = "18672948841";
    @Test
    public void getUserInfo(){
        UserInfo userInfo = new UserInfo();
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfo = userInfoMapper.selectOne(userInfoQueryWrapper.lambda().eq(UserInfo::getMobileNo,mobileNo));
        log.info(userInfo.toString());
    }

    @Test
    public void deleteUser(){
        UserInfo userInfo = new UserInfo();
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoMapper.delete(userInfoQueryWrapper.lambda().eq(UserInfo::getMobileNo,mobileNo));
        if(null==userInfoMapper.selectOne(userInfoQueryWrapper.lambda().eq(UserInfo::getMobileNo,mobileNo))){
            log.info("删除成功！");
        }

    }

    @Test
    public void putUser(){
        UserInfo userInfo = new UserInfo();
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfo.setBirthday("19930831");
        userInfo.setPassword("123456");
        userInfo.setMobileNo("18672958841");
        userInfo.setName("测试用户");
        userInfo.setNickName("test");
        userInfoMapper.insert(userInfo);
        log.info(userInfoMapper.selectOne(userInfoQueryWrapper.lambda().eq(UserInfo::getMobileNo,"18672958841")).getName());
    }

    @Test
    public void updateUserInfo(){
        UserInfo userInfo = new UserInfo();
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfo = userInfoMapper.selectOne(userInfoQueryWrapper.lambda().eq(UserInfo::getMobileNo,mobileNo));
        userInfo.setNickName("testeeee");
        userInfoMapper.updateById(userInfo);
        log.info(userInfoMapper.selectOne(userInfoQueryWrapper.lambda().eq(UserInfo::getMobileNo,mobileNo)).getNickName());
    }
}
