package com.xt.servlet;

import com.xt.entity.Book;
import com.xt.entity.Comment;
import com.xt.service.BookService;
import com.xt.service.CommentService;
import com.xt.service.impl.BookServiceImpl;
import com.xt.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/26 14:09
 * @since V1.00
 */
public class BookServlet extends HttpServlet {
    private BookService bookService=new BookServiceImpl();
    private CommentService commentService=new CommentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        if("list".equals(op)){
            List<Book> books=bookService.getAll();
            req.setAttribute("books",books);
            req.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(req,resp);
        }
        else if("one".equals(op)){
            int bid=0;
            try{
                bid=Integer.parseInt(req.getParameter("bid"));
                Book book=bookService.getById(bid);
                if(book!=null) {
                    req.setAttribute("book", book);
                    List<Comment> comments = commentService.getByBook(bid);
                    req.setAttribute("comments", comments);
                }
                else{
                    req.setAttribute("msg","查无此书");
                }
            }
            catch (Exception ex){
                req.setAttribute("msg",ex.getMessage());
            }

            req.getRequestDispatcher("/WEB-INF/pages/bookcomment.jsp").forward(req,resp);
        }
        else if("index".equals(op)){
            List<Integer> ids=bookService.getTopBookIds(4);
            req.setAttribute("ids",ids);
            req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("book?op=list").forward(req,resp);
        }
    }

}
