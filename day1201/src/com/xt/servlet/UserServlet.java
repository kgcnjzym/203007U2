package com.xt.servlet;

import com.alibaba.fastjson.JSON;
import com.xt.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/30 08:55
 * @since V1.00
 */
@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        String str="";
        if("list".equals(op)){
            List<User> us=new ArrayList<>();
            us.add(new User(1,"tom","qq",22));
            us.add(new User(2,"mike","ww",22));
            us.add(new User(3,"andy",null,22));
            us.add(new User(4,"jerry","qqqqq",22));
            str=JSON.toJSONString(us);
        }
        else if("set".equals(op)){
            Set<User> us=new HashSet<>();
            us.add(new User(1,"tom","qq",22));
            us.add(new User(2,"mike","ww",22));
            us.add(new User(3,"andy",null,22));
            us.add(new User(4,"jerry","qqqqq",22));
            str=JSON.toJSONString(us);
        }
        else if("map".equals(op)){
            Map<String,User> us=new HashMap<>();
            us.put("u1",new User(1,"tom","qq",22));
            us.put("u2",new User(2,"mike","ww",22));
            us.put("u3",new User(3,"andy",null,22));
            us.put("u4",new User(4,"jerry","qqqqq",22));
            str=JSON.toJSONString(us);
        }
        else if ("array".equals(op)){
            User[] us={new User(1,"tom","qq",22),
                    new User(2,"mike","ww",22),
                    new User(3,"andy",null,22),
                    new User(4,"jerry","qqqqq",22)
            };
            str=JSON.toJSONString(us);
        }
        else if ("one".equals(op)){
            User user=new User(1,"mi\"ke","mike@qq.com",23);
            user.setBirth(new Date());
            str= JSON.toJSONString(user);
        }
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.write(str);
        out.close();

    }
}
