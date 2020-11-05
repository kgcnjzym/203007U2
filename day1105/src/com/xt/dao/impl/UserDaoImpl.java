package com.xt.dao.impl;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.util.jdbc.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 10:35
 * @since V1.00
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) {
        String sql="insert into users values(" +
                user.getId()+",'"+user.getName()+"','" +
                user.getPassword()+"','"+
                user.getGender()+"',"+
                user.getAge()+",'"+
                user.getPhone()+"')";
        System.out.println("insert:"+sql);
        return DataBaseUtil.update(sql);
    }

    @Override
    public User selectUser(User user) {
        String sql="select * from users where name=? and password=?";
        Connection conn=null;
        ResultSet rs=null;
        try{
            conn=DataBaseUtil.getConnection();
            rs=DataBaseUtil.query(conn,sql,user.getName(),user.getPassword());
            if(rs.next()){
                User ret=new User();
                ret.setId(rs.getInt(1));
                ret.setName(rs.getString(2));
                ret.setPassword(rs.getString(3));
                ret.setGender(rs.getString(4));
                ret.setAge(rs.getInt(5));
                ret.setPhone(rs.getString(6));
                return ret;
            }
            else{
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            DataBaseUtil.closeQuietly(conn,null,rs);
        }
        return null;
    }
}
