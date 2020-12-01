package com.xt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/30 08:55
 * @since V1.00
 */
@WebServlet("/third.do")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //以下方式，兼容旧版浏览器，但jquery获取时需指定数据格式为json
//        resp.setContentType("text/plain;charset=UTF-8");
        //以下方式不兼容旧版浏览器，但jquery获取时无需指定数据格式
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        String name="ja\"ck";
        out.write("[{\"id\":\"s1\",\"name\":\""+name.replace("\"","\\\"")+"\",\"age\":20}," +
                "{\"id\":\"s2\"," +
                "\"name\":\"marry\",\"age\":22}]");
        out.close();
    }
}
