package org.smart4j.chapter2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by caowei on 2017/11/17.
 */
@WebServlet(name = "CustomerCreateServlet",value = "/customer_create")
public class CustomerCreateServlet extends HttpServlet {
    /**
     * 创建客户 请求
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO
    }

    /**
     * 创建客户 界面
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO
    }



}
