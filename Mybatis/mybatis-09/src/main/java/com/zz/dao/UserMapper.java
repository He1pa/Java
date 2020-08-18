package com.zz.dao;

import com.zz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User queryUserById(@Param("id") int id);
}
