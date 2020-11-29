package com.xt.servlet;

import com.xt.entity.Comment;
import com.xt.entity.User;
import com.xt.service.CommentService;
import com.xt.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/29 21:26
 * @since V1.00
 */
@WebServlet("/comment.do")
public class CommentServlet extends HttpServlet {
    private CommentService service=new CommentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        String sid=req.getParameter("bid");
        HttpSession session=req.getSession();
        User user= (User) session.getAttribute("user");
        if(title==null || title.trim().equals("")){
            req.setAttribute("msg","评论标题不能为空");
        }
        else if(content==null || content.trim().equals("")){
            req.setAttribute("msg","评论内容不能为空");
        }
        else{
            try{
                int bid=Integer.parseInt(sid);
                Comment comment=new Comment();
                comment.setContent(content);
                comment.setTitle(title);
                comment.setBid(bid);
                comment.setUid(user.getId());
                int ret=service.add(comment);
                if(ret>0){
                    req.setAttribute("msg","评论成功");
                }
                else{
                    req.setAttribute("msg","评论失败");
                }
            }
            catch (NumberFormatException ex){
                req.setAttribute("msg","参数有误");
            }
        }
        req.getRequestDispatcher("book?op=one&bid="+sid).forward(req,resp);
    }
}
