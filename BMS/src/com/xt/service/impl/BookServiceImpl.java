package com.xt.service.impl;

import com.xt.dao.BookDao;
import com.xt.dao.impl.BookDaoImpl;
import com.xt.entity.Book;
import com.xt.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Book getById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public int add(Book book) {
        return dao.insert(book);
    }

    @Override
    public List<Integer> getTopBookIds(Integer limit) {
        List<Book> books=dao.selectTop(limit);
        return books.stream().map(b->b.getId()).
                collect(Collectors.toList());
    }
}
