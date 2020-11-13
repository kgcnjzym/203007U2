package com.xt.service;

import com.xt.entity.Book;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/13 09:07
 * @since V1.00
 */
public interface BookService {
    /**
     *
     * @return
     */
    List<Book> getAll();
}
