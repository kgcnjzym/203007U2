package com.xt.mapper;

import com.xt.entity.Book;
import com.xt.util.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 11:06
 * @since V1.00
 */
public class BookMapper implements RowMapper<Book> {
    @Override
    public Book convert(ResultSet rs) {
        Book ret=new Book();
        try {
            ret.setId(rs.getInt("bid"));
        } catch (SQLException e) {
        }
        try {
            ret.setName(rs.getString("bname"));
        } catch (SQLException e) {
        }
        try {
            ret.setAuthor(rs.getString("author"));
        } catch (SQLException e) {
        }
        try {
            ret.setPubComp(rs.getString("pubcomp"));
        } catch (SQLException e) {
        }
        try {
            ret.setCount(rs.getInt("bcount"));
        } catch (SQLException e) {
        }
        try {
            ret.setPubDate(rs.getTimestamp("pubdate"));
        } catch (SQLException e) {
        }
        try {
            ret.setPrice(rs.getDouble("price"));
        } catch (SQLException e) {
        }
        return ret;
    }
}
