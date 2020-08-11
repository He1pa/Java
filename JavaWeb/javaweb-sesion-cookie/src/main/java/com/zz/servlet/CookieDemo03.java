package com.zz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

//中文传递数据
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-16");
        resp.setCharacterEncoding("utf-16");

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            out.write("name:");
            for (Cookie cookie : cookies) {
                //获取cookies的名字
                if (cookie.getName().equals("name")) {
                    out.write(cookie.getValue());
                    //out.write(URLDecoder.decode(cookie.getValue(),"utf-8"));
                }
            }
        }else {
            out.write("第一次访问");
        }

        Cookie cookie = new Cookie("name", "黑怕");
        //Cookie cookie = new Cookie("name", URLEncoder.encode("黑怕","utf-8"));


        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
