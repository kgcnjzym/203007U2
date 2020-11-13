package com.xt.service.impl;

import com.xt.dao.BookDao;
import com.xt.dao.impl.BookDaoImpl;
import com.xt.entity.Book;
import com.xt.service.BookService;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/13 09:07
 * @since V1.00
 */
public class BookServiceImpl implements BookService {
    private BookDao dao=new BookDaoImpl();
    @Override
    public List<Book> getAll() {
        return dao.selectAll();
    }
}
