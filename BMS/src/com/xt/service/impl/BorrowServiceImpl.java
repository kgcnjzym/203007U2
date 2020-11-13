package com.xt.service.impl;

import com.xt.dao.BookDao;
import com.xt.dao.BorrowDao;
import com.xt.dao.impl.BookDaoImpl;
import com.xt.dao.impl.BorrowDaoImpl;
import com.xt.entity.Borrow;
import com.xt.service.BorrowService;
import com.xt.util.jdbc.TransactionManager;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/13 10:38
 * @since V1.00
 */
public class BorrowServiceImpl implements BorrowService {
    private BookDao bookDao=new BookDaoImpl();
    private BorrowDao borrowDao=new BorrowDaoImpl();
    private TransactionManager tm=new TransactionManager();
    @Override
    public int lend(Integer uid, Integer bid) {
        try{
            tm.start();
            int ret=bookDao.selectCountById(bid);
            if(ret==0){
                throw  new RuntimeException("图书不存在或库存不足");
            }
            Borrow borrow=new Borrow();
            borrow.setBid(bid);
            borrow.setRid(uid);
            ret=borrowDao.insert(borrow);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ret==0){
                throw  new RuntimeException("借阅记录添加失败");
            }
            ret=bookDao.updateCount(bid,1);
            if(ret==0) {
                throw new RuntimeException("修改图书库存失败");
            }
            tm.commit();
            return ret;
        }
        catch (RuntimeException ex){
            tm.rollback();
            throw ex;
        }
    }
}
