package com.meng.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig servletConfig = this.getServletConfig();
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.printf("encoding:%s%n", encoding);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get收到");
        System.out.println("请求方式："+req.getMethod());
        System.out.println(req.getRequestURI());
        Enumeration<String> headerNames = req.getHeaderNames();
                while (headerNames.hasMoreElements()){
                    String element = headerNames.nextElement();
                    System.out.println(element+":"+req.getHeader(element));
                }
        String name = req.getParameter("name");
                String passWord = req.getParameter("passWord");
        System.out.println(name+passWord);
        String result = "登录成功";
//        ServletOutputStream so = resp.getOutputStream();
//        so.write(result.getBytes());
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post收到");


    }
}
