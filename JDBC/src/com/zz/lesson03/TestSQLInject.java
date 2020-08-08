package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.*;

public class TestSQLInject {
    public static void main(String[] args) throws SQLException {
        login("' or '1=1","' or '1=1");
        login("zz","123456");
    }
    public static  void login(String username,String password) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try {
            //SELECT * FROM `users` WHERE `NAME`='' or 1=1 AND `PASSWORD`='' or 1=1 ;
            //获取连接
            conn = JdbcUtils.getConnection();
            //PrepareStatement 防止SQL注入的本质，把传递进来的参数当作字符
            //其中存在转义字符会被直接转义
            //sql
            String sql="SELECT * FROM `users` WHERE `NAME`= ? AND `PASSWORD`=?";
            //查询获取返回集合
            st = conn.prepareStatement(sql);

            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeQuery();
            //遍历
            while (rs.next()){
                System.out.println(rs.getObject("NAME"));
                System.out.println(rs.getObject("PASSWORD"));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
