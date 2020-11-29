package com.xt.dao.impl;

import com.xt.dao.CommentDao;
import com.xt.entity.Comment;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/26 14:06
 * @since V1.00
 */
public class CommentDaoImpl implements CommentDao {
    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public int insert(Comment comment) {
        String sql="insert into bookcomment values(0,?,?,?,?)";
        return template.update(sql,true,
                comment.getUid(),comment.getBid(),
                comment.getTitle(),comment.getContent());
    }

    @Override
    public List<Comment> selectByBook(Integer bid) {
        String sql="select * from bookcomment where bid=?";
        return template.queryList(sql,Comment.class,bid);
    }
}
