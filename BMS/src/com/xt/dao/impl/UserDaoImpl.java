package com.xt.dao.impl;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.util.jdbc.JdbcTemplate;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/9 10:15
 * @since V1.00
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate();

    @Override
    public int insert(User user) {
        String sql="insert into users values(0,?,?,?,?,?,?,1)";
        return template.update(sql,true,user.getName(),
                user.getPassword(),user.getEmail(),user.getGender(),
                user.getAge(),user.getPhone());
    }

    @Override
    public User selectByUser(User user) {
        String sql="select id, name, email, gender, age, phone, state from users where " +
                "(name=? or email=? or phone=?) " +
                "and (password=?) " +
                "and (state>0)";
        return template.queryOne(sql,User.class,user.getName()
                ,user.getName(),user.getName(),user.getPassword());
    }

    @Override
    public int selectByName(String name,Integer uid) {
        String sql="select count(1) from users where name=? and id!=?";
        return template.queryScale(sql,Integer.class,name,uid);
    }

    @Override
    public int selectByEmail(String email,Integer uid) {
        String sql="select count(1) from users where email=? and id!=?";
        return template.queryScale(sql,Integer.class,email,uid);
    }

    @Override
    public int selectByPhone(String phone,Integer uid) {
        String sql="select count(1) from users where phone=? and id!=?";
        return template.queryScale(sql,Integer.class,phone,uid);
    }

    @Override
    public int updatePassword(String newPass, String oldPass, Integer uid) {
        String sql="update users set password=? where id=? and password=?";
        return template.update(sql,false,newPass,uid,oldPass);
    }

    @Override
    public int updateInfo(User user) {
        String sql="update users set name=?,email=?," +
                "gender=?,age=?,phone=? where id=?";
        return template.update(sql,false,user.getName(),
                user.getEmail(),user.getGender(),user.getAge(),
                user.getPhone(),user.getId());
    }

    @Override
    public int updateScore(Integer uid, Integer score) {
        String sql="update users set score=score-? where id=? and score>=?";
        return template.update(sql,false,score,uid,score);
    }
}
