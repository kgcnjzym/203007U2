package com.xt.dao;

import com.xt.entity.Comment;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/26 14:05
 * @since V1.00
 */
public interface CommentDao {
    /**
     * 添加
     * @param comment
     * @return
     */
    int insert(Comment comment);

    /**
     * 根据图书获取评论
     * @param bid
     * @return
     */
    List<Comment> selectByBook(Integer bid);
}
