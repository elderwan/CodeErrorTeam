package com.ElderWan.service.impl;

import com.ElderWan.entity.Emp;
import com.ElderWan.entity.User;
import com.ElderWan.mapper.UserMapper;
import com.ElderWan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

/*    @Transactional
    @Override
    public void register(User user) {
        this.userMapper.insert(user);
    }*/

    @Transactional
    @Override
    public User login(String user_name, String pwd) {
        User user = this.userMapper.getByNameAndPwd(user_name,pwd);
        return user;
    }

}
