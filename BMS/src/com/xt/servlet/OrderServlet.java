package com.xt.servlet;

import com.xt.entity.Book;
import com.xt.entity.Order;
import com.xt.entity.User;
import com.xt.service.OrderService;
import com.xt.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/29 20:16
 * @since V1.00
 */
@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
    private OrderService service=new OrderServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        HttpSession session=req.getSession();
        User user= (User) session.getAttribute("user");
        if("list".equals(op)){
            String url=doList(req,resp,user);
            req.getRequestDispatcher(url).forward(req,resp);
        }
        else if("show".equals(op)){
            req.getRequestDispatcher("/WEB-INF/pages/order.jsp").forward(req,resp);
        }
        else if("confirm".equals(op)){
            String url=doConfirm(req,resp,user);
            req.getRequestDispatcher(url).forward(req,resp);
        }
        else if("del".equals(op)){
            doDel(req,resp,user);
            req.getRequestDispatcher(doList(req,resp,user)).forward(req,resp);
        }
        else{
            req.getRequestDispatcher("/WEB-INF/pages/carts.jsp").forward(req,resp);
        }
    }

    private void doDel(HttpServletRequest req, HttpServletResponse resp,User user) throws ServletException, IOException{
        int oid=0;
        try{
            oid=Integer.parseInt(req.getParameter("oid"));
            Order order=new Order();
            order.setOid(oid);
            order.setUid(user.getId());
            int ret=service.deleteOrder(order);
            if(ret>0) {
                req.setAttribute("msg", "订单编号【" + ret+"】删除成功");
            }
            else{
                req.setAttribute("msg", "订单编号【" + ret+"】删除失败");
            }
        }
        catch (NumberFormatException ex){
            req.setAttribute("msg","订单编号不合法");
        }
        catch (RuntimeException ex){
            req.setAttribute("msg",ex.getMessage());
        }
    }

    private String doConfirm(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException{
        String address=req.getParameter("address");
        HttpSession session=req.getSession();
//    user.getId()
        Map<String, Book> carts=(Map<String, Book>)session.getAttribute("carts");
        OrderService service=new OrderServiceImpl();
        try{
            int ret=service.addOrder(user.getId(),
                    new ArrayList(carts.values()));
            if(ret>0) {
                session.removeAttribute("carts");
                req.setAttribute("msg", "添加成功，订单编号：" + ret);
                return "book?op=list";
            }
        }
        catch (RuntimeException ex){
            req.setAttribute("msg",ex.getMessage());
        }
        return "/WEB-INF/pages/order.jsp";
    }

    private String doList(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException{

        List<Order> orders=service.getByUser(user.getId());
        req.setAttribute("orders",orders);
        return "/WEB-INF/pages/myorders.jsp";
    }
}
