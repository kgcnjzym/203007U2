package com.xt.service.impl;

import com.xt.dao.UserDao;
import com.xt.dao.impl.UserDaoImpl;
import com.xt.entity.User;
import com.xt.service.UserService;
import com.xt.util.jdbc.TransactionManager;
import com.xt.utils.Md5Util;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/9 10:39
 * @since V1.00
 */
public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    private TransactionManager tm=new TransactionManager();
    @Override
    public int reg(User user) {
        try{
            tm.start();
            int ret=dao.selectByName(user.getName(),0);
            if(ret>0){
                throw new RuntimeException("用户名["+user.getName()+"]已存在！");
            }
            ret=dao.selectByEmail(user.getEmail(),0);
            if(ret>0){
                throw new RuntimeException("Email["+user.getEmail()+"]已存在！");
            }
            ret=dao.selectByPhone(user.getPhone(),0);
            if(ret>0){
                throw new RuntimeException("手机号["+user.getPhone()+"]已存在！");
            }
            user.setPassword(Md5Util.getMD5(user.getPassword()));
            ret=dao.insert(user);
            tm.commit();
            return ret;
        }
        catch (RuntimeException ex){
            tm.rollback();
            throw ex;
        }
    }

    @Override
    public User login(User user) {
        user.setPassword(Md5Util.getMD5(user.getPassword()));
        return dao.selectByUser(user);
    }

    @Override
    public int modifyPass(String newPass, String oldPass, Integer uid) {
        return dao.updatePassword(Md5Util.getMD5(newPass),
                Md5Util.getMD5(oldPass),uid);
    }

    @Override
    public int modifyInfo(User user) {
        try{
            tm.start();
            int ret=dao.selectByName(user.getName(),user.getId());
            if(ret>0){
                throw new RuntimeException("用户名["+user.getName()+"]已存在！");
            }
            ret=dao.selectByEmail(user.getEmail(),user.getId());
            if(ret>0){
                throw new RuntimeException("Email["+user.getEmail()+"]已存在！");
            }
            ret=dao.selectByPhone(user.getPhone(),user.getId());
            if(ret>0){
                throw new RuntimeException("手机号["+user.getPhone()+"]已存在！");
            }
            ret=dao.updateInfo(user);
            tm.commit();
            return ret;
        }
        catch (RuntimeException ex){
            tm.rollback();
            throw ex;
        }

    }
}
