package com.xt.dao.impl;

import com.xt.dao.BookDao;
import com.xt.entity.Book;
import com.xt.mapper.BookMapper;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 11:10
 * @since V1.00
 */
public class BookDaoImpl implements BookDao {
    private JdbcTemplate template=new JdbcTemplate();
    private BookMapper mapper=new BookMapper();
    @Override
    public Book selectById(Integer id) {
        String sql="select * from book where bid=?";
        return template.queryOne(sql,mapper,id);
    }

    @Override
    public List<Book> selectByName(String name) {
        String sql="select * from book where bname like concat('%',?,'%')";
        return template.queryList(sql,mapper,name);
    }
}
