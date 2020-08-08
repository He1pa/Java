package com.zz.lesson01;

import com.sun.org.apache.xml.internal.utils.res.XResources_ko;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1 加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()) ;
        Class.forName("com.mysql.jdbc.Driver");
        //2 用户信息和url useUnicode=true&characterEncoding=utf8&useSSL=true
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "123456";
        //3 连接成功，获得数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);
        //4 执行SQL的对象
        Statement statement = connection.createStatement();



        //5 执行SQL的对象 去执行SQL，可能存在结果，查看结果
        String sql = "SELECT * FROM`users`;";
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("NAME"));
            System.out.println("pwd="+resultSet.getObject("PASSWORD"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birth="+resultSet.getObject("birthday"));
        }
        //6 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
