package com.xt.dao;

import com.xt.entity.Book;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 11:09
 * @since V1.00
 */
public interface BookDao {
    /**
     * 根据图书Id查找
     * @param id
     * @return
     */
    Book selectById(Integer id);

    /**
     * 根据图书名模糊查找
     * @param name
     * @return
     */
    List<Book> selectByName(String name);
}
