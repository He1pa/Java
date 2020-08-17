package com.zz.dao;

import com.zz.pojo.User;
import com.zz.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserListTest(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper= session.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);


        System.out.println(user);
        session.close();

    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void  getUserByLimitTest(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper= session.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();

    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSession();
//RowBounds实现
        RowBounds rowBounds = new RowBounds(0, 2);
//通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.zz.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }


}
