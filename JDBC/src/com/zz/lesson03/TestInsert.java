package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;
import java.util.Date;
import java.sql.*;

public class TestInsert {
    public static void main(String[] args) {
        Connection cnn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cnn = JdbcUtils.getConnection();
            //区别
            //使用?占位符
            String sql = "INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`) VALUES(?,?,?,?,?)";
            pstm = cnn.prepareStatement(sql);//预编译SQL，先写SQL，不执行
            pstm.setInt(1,4);
            pstm.setString(2,"asda");
            pstm.setString(3,"asda");
            pstm.setString(4,"asda");
            //util.Date 与 sql.Date 不同
            pstm.setDate(5,new java.sql.Date(new Date().getTime()));

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
