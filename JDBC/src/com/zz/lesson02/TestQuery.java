package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestQuery {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "SELECT * FROM `users` where `id` = 1";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("NAME"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,st,rs);
        }
    }
}
