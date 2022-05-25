package com.ElderWan.mapper;

import com.ElderWan.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
   // void insert( User user);
    User getByNameAndPwd(@Param("user_name") String user_name,@Param("pwd")String pwd);
    User getByName(@Param("user_name")String name);
}
