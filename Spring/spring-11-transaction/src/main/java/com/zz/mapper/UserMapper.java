package com.zz.mapper;

import com.zz.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();

    public int addUser(User user);

    public int deleteUser(int id);


}
