package com.zz.lesson04;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);


            String sql1 = "update account set money = money - 100 where NAME =  'a'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
            String sql2 = "update account set money = money + 100 where NAME =  'b'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            //业务完毕提交事务
            conn.commit();
            System.out.println("成功");

        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
