package com.angers.project.service.impl;

import com.angers.project.entity.UserInfo;
import com.angers.project.mapper.UserInfoMapper;
import com.angers.project.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author anger
 * @since 2021-07-20
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
