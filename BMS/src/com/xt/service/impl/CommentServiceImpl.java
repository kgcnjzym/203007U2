package com.xt.service.impl;

import com.xt.dao.BookDao;
import com.xt.dao.CommentDao;
import com.xt.dao.impl.BookDaoImpl;
import com.xt.dao.impl.CommentDaoImpl;
import com.xt.entity.Book;
import com.xt.entity.Comment;
import com.xt.service.CommentService;
import com.xt.util.jdbc.TransactionManager;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/26 14:12
 * @since V1.00
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao dao=new CommentDaoImpl();
    private BookDao bookDao=new BookDaoImpl();
    private TransactionManager tm=new TransactionManager();
    @Override
    public int add(Comment comment) {
        try{
            tm.start();
            Book book=bookDao.selectById(comment.getBid());
            if(book==null){
                throw new RuntimeException("查无编号为【"+comment.getBid()+"】的图书");
            }
            int ret=dao.insert(comment);
            tm.commit();
            return ret;
        }
        catch (RuntimeException ex){
            tm.rollback();
            throw ex;
        }
    }

    @Override
    public List<Comment> getByBook(Integer bid) {
        return dao.selectByBook(bid);
    }
}
