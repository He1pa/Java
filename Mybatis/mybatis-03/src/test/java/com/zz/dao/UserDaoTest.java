package com.zz.dao;

import com.zz.pojo.User;
import com.zz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void getUserListTest(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper= session.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);


        System.out.println(user);

    }
}
