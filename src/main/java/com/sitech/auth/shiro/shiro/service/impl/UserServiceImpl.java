package com.sitech.auth.shiro.shiro.service.impl;

import com.sitech.auth.shiro.shiro.entity.User;
import com.sitech.auth.shiro.shiro.dao.UserMapper;
import com.sitech.auth.shiro.shiro.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liugd
 * @since 2018-08-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
