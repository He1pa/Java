package com.zz.dao;

import com.zz.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);
    //分页实现查询
    List<User> getUserByLimit(Map<String,Integer> map);
    //分页2
    List<User> getUserByRowBounds();
}
