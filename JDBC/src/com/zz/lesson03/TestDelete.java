package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestDelete {
    public static void main(String[] args) {
        Connection cnn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cnn = JdbcUtils.getConnection();
            //区别
            //使用?占位符
            String sql = "delete from `users` where `id` = ?";
            pstm = cnn.prepareStatement(sql);//预编译SQL，先写SQL，不执行
            pstm.setInt(1,4);



            int i = pstm.executeUpdate();
            if(i>0){
                System.out.println("成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,pstm,rs);
        }
    }
}
