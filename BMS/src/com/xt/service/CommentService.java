package com.xt.service;

import com.xt.entity.Comment;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/26 14:11
 * @since V1.00
 */
public interface CommentService {
    /**
     * 添加
     * @param comment
     * @return
     */
    int add(Comment comment);

    /**
     * 根据图书id查找
     * @param bid
     * @return
     */
    List<Comment> getByBook(Integer bid);
}
