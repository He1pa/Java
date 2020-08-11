package com.zz.servlet;

import com.zz.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

//保存用户上一次访问的时间
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到session
        HttpSession session = req.getSession();

        //给session存东西
        //session.setAttribute("name","黑怕");
        session.setAttribute("name",new Person("zz",1));

        //获取session的id
        String id = session.getId();

        //判断session是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("session创建成功，ID:" + id);
        }else {
            resp.getWriter().write("session id:" + id);
        }
        //session创建的时候做了什么事情
//        Cookie jsessionid = new Cookie("JSESSIONID", id);
//        resp.addCookie(jsessionid);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
