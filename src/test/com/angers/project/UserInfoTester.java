package com.angers.project;

import com.angers.project.dao.UserInfoMapper;
import com.angers.project.model.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class UserInfoTester extends Tester{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void listUsers(){
        log.info("userinfo测试开发。。。");
        List<UserInfo> userInfoList = userInfoMapper.selectList(null);
        for (UserInfo userInfo:userInfoList){
            log.info(userInfo.toString());
        }
    }

    @Test
    public void addUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("安格");
        userInfo.setMobileNo("18672948847");
        userInfo.setBirthday("19990909");
        userInfo.setSex(0);
        userInfo.setNickName("anger");
        userInfo.setPassword("111222");
        userInfoMapper.insert(userInfo);
        log.info("插入用户信息成功："+userInfoMapper.selectOne(new QueryWrapper<>(userInfo).eq("mobile_no","18672948847")));
    }

    @Test
    public void deleteUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName("yueyue1");
        userInfoMapper.delete(new QueryWrapper<UserInfo>().eq("nick_name","yueyue1"));
        log.info("用户信息删除成功"+userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("nick_name","yueyue1")));
    }

    @Test
    public void updateUser(){
        UserInfo userInfo = userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("nick_name","yueyue1"));
        String nickName = userInfo.getNickName();
        userInfo.setNickName("yueyue100");
        userInfoMapper.updateById(userInfo);
        log.info("用户信息更新成功，原nickname："+nickName+"，新nickName:"+userInfoMapper.selectById(userInfo.getId()).getNickName());
    }
}
