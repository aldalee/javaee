package com.aleecoder.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuanyuLee
 * @date 2022/3/31
 */
@WebServlet("/myServlet.do")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求转发
        req.getRequestDispatcher("hello.jsp").forward(req,resp);
    }
}
