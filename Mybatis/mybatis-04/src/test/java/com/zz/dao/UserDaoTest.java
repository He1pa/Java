package com.zz.dao;

import com.zz.pojo.User;
import com.zz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;



public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserListTest(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper= session.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);


        System.out.println(user);

    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }


}
