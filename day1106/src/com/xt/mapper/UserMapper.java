package com.xt.mapper;

import com.xt.entity.User;
import com.xt.util.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 10:05
 * @since V1.00
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User convert(ResultSet rs) {
        User ret=new User();
        try {
            ret.setId(rs.getInt("id"));
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        try {
            ret.setName(rs.getString("name"));
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        try {
            ret.setPassword(rs.getString("password"));
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        try {
            ret.setGender(rs.getString("gender"));
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        try {
            ret.setAge(rs.getInt("age"));
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        try {
            ret.setPhone(rs.getString("phone"));
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        return ret;
    }
}
