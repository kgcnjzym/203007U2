package com.xt.service.impl;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 09:58
 * @since V1.00
 */
//@Service
public class UserServiceImpl implements UserService {
    @Resource
    private PlatformTransactionManager transactionManager;
    @Resource
    private UserDao dao;
    @Override
    public int reg(User user) {
        int ret=0;
        DefaultTransactionDefinition dtd=new DefaultTransactionDefinition();
//        dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        dtd.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        TransactionStatus status=transactionManager.getTransaction(dtd);

        try{
            dao.update(173);
            ret=dao.insert(user);
            transactionManager.commit(status);
        }
        catch (Exception ex){
            transactionManager.rollback(status);
            throw new RuntimeException("用户名已存在");
        }
        return ret;
    }

    @Override
    public User getById(Integer id) {
        return dao.selectById(id);
    }


}
