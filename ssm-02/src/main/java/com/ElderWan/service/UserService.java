package com.ElderWan.service;

import com.ElderWan.entity.Emp;
import com.ElderWan.entity.User;

import java.util.List;

public interface UserService {
    //void  register(User user);
    User login(String user_name,String pwd);


}
