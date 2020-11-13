package com.xt.dao.impl;

import com.xt.dao.BookDao;
import com.xt.entity.Book;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/13 09:02
 * @since V1.00
 */
public class BookDaoImpl implements BookDao {
    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public Book selectById(Integer id) {
        String sql="select bid id, bName name, author, pubComp, pubDate, bCount count, price from book where bid=?";
        return template.queryOne(sql,Book.class,id);
    }

    @Override
    public List<Book> selectByName(String name) {
        String sql="select bid id, bName name, author, pubComp, pubDate, bCount count, price from book where bname like concat('%',?,'%')";
        return template.queryList(sql,Book.class,name);
    }

    @Override
    public List<Book> selectAll() {
        String sql="select bid id, bName name, author, pubComp, pubDate, bCount count, price from book";
        return template.queryList(sql,Book.class);
    }

    @Override
    public int selectCountById(Integer bid) {
        String sql="select count(1) from book where bid=? and bcount>0";
        return template.queryScale(sql,Integer.class,bid);
    }

    @Override
    public int updateCount(Integer bid, int count) {
        String sql="update book set bcount=bcount-? where bid=? and bcount>=?";
        return template.update(sql,false,count,bid,count);
    }
}
