package com.johnzero.useraccount.service;

import com.johnzero.model.useraccount.User;
import com.johnzero.useraccount.mapper.UserMapper;
import com.johnzero.useraccount.service.impl.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/6/25 5:36
  Description: 
*/
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过邮箱和密码获取用户
     * @param email
     * @param password
     * @return
     */
    public User getUserByEmail(String email, String password) {
        return userMapper.getUserByEmail(email, password);
    }
}
