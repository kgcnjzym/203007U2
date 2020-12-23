package com.xt.service.impl;

import com.github.pagehelper.PageHelper;
import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.service.UserService;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/23 09:15
 * @since V1.00
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getByPage(Integer pno, Integer psize) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            PageHelper.startPage(pno,psize);
            return dao.queryAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }

    }
}
