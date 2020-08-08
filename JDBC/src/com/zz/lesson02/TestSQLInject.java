package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;
import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLInject {
    public static void main(String[] args) throws SQLException {
        login("' or '1=1","' or '1=1");
    }
    public static  void login(String username,String password) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            //SELECT * FROM `users` WHERE `NAME`='' or 1=1 AND `PASSWORD`='' or 1=1 ;
            //获取连接
            connection = JdbcUtils.getConnection();
            //获取sql对象
            statement = connection.createStatement();
            //sql
            String sql="SELECT * FROM `users` WHERE `NAME`= "+"'"+username+"'"+" AND `PASSWORD`="+"'"+password+"'";
            //查询获取返回集合
            ResultSet query = statement.executeQuery(sql);
            //遍历
            while (query.next()){
                System.out.println(query.getObject("NAME"));
                System.out.println(query.getObject("PASSWORD"));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection,statement,rs);
        }
    }
}
