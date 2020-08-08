package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`)\n" +
                    "VALUES('4','z','123456','123124@qq.com','1990-12-11')";
            int i = st.executeUpdate(sql);
            if (i >0){
                System.out.println("成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,st,rs);
        }
    }
}
