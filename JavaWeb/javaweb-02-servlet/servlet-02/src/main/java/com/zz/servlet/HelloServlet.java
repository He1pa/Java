package com.zz.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //this.getInitParameter();
        //this.getServletConfig();
        ServletContext servletContext = this.getServletContext();
        String name = "zz";
        servletContext.setAttribute("username",name);//将数据保存在context中，名字为username，值为“zz”
        System.out.println("hello");
    }


}
