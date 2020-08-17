package com.zz.dao;

import com.zz.pojo.User;

public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);

}
