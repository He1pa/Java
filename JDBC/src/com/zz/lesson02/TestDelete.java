package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "DELETE FROM `users` WHERE id = 4";
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
