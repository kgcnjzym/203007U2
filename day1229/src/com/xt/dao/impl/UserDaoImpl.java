package com.xt.dao.impl;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 09:54
 * @since V1.00
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static Logger logger=Logger.getRootLogger();
    @Resource
    /**
     * 4.注入JdbcTemplate对象
     */
    private JdbcTemplate template;
    @Override
    public int insert(User user) {
        String sql="insert into users(name,email,phone) values(?,?,?)";
        KeyHolder key=new GeneratedKeyHolder();
        int ret=template.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1,user.getName());
                pstmt.setString(2,user.getEmail());
                pstmt.setString(3,user.getPhone());
                return pstmt;
            }
        },key);
        if(ret>0){
            int id=key.getKey().intValue();
            user.setId(id);
        }
        return ret;
//        return template.update(sql,user.getName(),user.getEmail(),user.getPhone());
    }

    @Override
    public User selectById(Integer id) {
        String sql="select * from users where id=?";
        try {
            return template.queryForObject(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User temp = new User();
                    try {
                        temp.setId(resultSet.getInt("id"));
                    } catch (Exception e) {
                    }
                    try {
                        temp.setName(resultSet.getString("name"));
                    } catch (Exception e) {
                    }
                    try {
                        temp.setEmail(resultSet.getString("email"));
                    } catch (Exception e) {
                    }
                    try {
                        temp.setPhone(resultSet.getString("phone"));
                    } catch (Exception e) {
                    }
                    return temp;
                }
            }, id);
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public int update(Integer id) {
        String sql="update users set score=score+1 where id=?";
        logger.info("SQL:"+sql);
        int ret=template.update(sql,id);
        logger.info("update ret="+ret);
        return ret;
    }
}
