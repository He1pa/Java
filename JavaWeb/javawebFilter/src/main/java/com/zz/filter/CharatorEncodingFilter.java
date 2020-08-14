package com.zz.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharatorEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }
    // chain 链
    /*
    * 1 过滤器中所有的代码，在过滤特定请求的时候都会执行
    * 2 必须要让过滤器继续通行
    * */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTG-8");

        System.out.println("执行前");
        filterChain.doFilter(servletRequest, servletResponse);//让请求继续，如果不写就停止了
        System.out.println("执行后");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
