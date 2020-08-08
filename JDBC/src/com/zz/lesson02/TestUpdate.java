package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "UPDATE `users` SET `NAME`='zz' WHERE `id` = 1";
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
