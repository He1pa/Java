package com.zz.service;

import com.zz.dao.UserDao;
import com.zz.dao.UserDaoImpl;
import com.zz.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    //用户实际调用的是业务层，dao层不需要接触
    // 利用set实现
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser(){
        userDao.getUser();
    }
}
