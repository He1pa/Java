package com.zz.dao;

import com.zz.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);




    //增加用户
    int addUser(User user);

    //  修改用户
    int updateUser(User user);

    int deleteUser(int id);
}
