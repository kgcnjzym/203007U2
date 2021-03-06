package com.xt.servlet;

import com.xt.entity.Paginate;
import com.xt.entity.User;
import com.xt.service.UserService;
import com.xt.service.UserState;
import com.xt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/23 11:10
 * @since V1.00
 */
public class UserAdminServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        if(user.getState()<=1){
            resp.sendRedirect("index.jsp");
            return;
        }
        String op=req.getParameter("op");
        int id=0;
        try{
            id=Integer.parseInt(req.getParameter("id"));
        }
        catch (Exception ex){}
        int ret=-1;
        if("del".equals(op)){
            ret=userService.delete(id);
        }
        else if("rec".equals(op)){
            ret=userService.recover(id);
        }
        else if(user.getState().equals(UserState.SUPER_ADMIN)
                &&   "deg".equals(op)){
            ret=userService.degrade(id);
        }
        else if(user.getState().equals(UserState.SUPER_ADMIN)
                &&  "upg".equals(op)){
            ret=userService.upgrade(id);
        }
        if(ret>0){
            req.setAttribute("msg","操作成功");
        }
        else if(ret==-1){
            //req.setAttribute("msg","权限不足或无此功能");
        }
        else{
            req.setAttribute("msg","操作失败");
        }
        Paginate pg=new Paginate();
        try{
            pg.setPageNo(Integer.parseInt(req.getParameter("pno")));
        }
        catch (Exception ex){
            pg.setPageNo(1);
        }
        try{
            pg.setPageSize(Integer.parseInt(req.getParameter("psize")));
        }
        catch (Exception ex){
            pg.setPageSize(1);
        }
        List<User> users=userService.getByPage(pg);
        req.setAttribute("users",users);
        req.setAttribute("pg",pg);
        req.getRequestDispatcher("/WEB-INF/pages/useradmin.jsp").forward(req,resp);
    }
}
