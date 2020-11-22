package com.xt.service.impl;

import com.xt.dao.BookDao;
import com.xt.dao.OrderDao;
import com.xt.dao.OrderDetailDao;
import com.xt.dao.UserDao;
import com.xt.dao.impl.BookDaoImpl;
import com.xt.dao.impl.OrderDaoImpl;
import com.xt.dao.impl.OrderDetailDaoImpl;
import com.xt.dao.impl.UserDaoImpl;
import com.xt.entity.Book;
import com.xt.entity.Order;
import com.xt.entity.OrderDetail;
import com.xt.service.OrderService;
import com.xt.util.jdbc.TransactionManager;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 09:08
 * @since V1.00
 */
public class OrderServiceImpl implements OrderService {
    private BookDao bookDao=new BookDaoImpl();
    private OrderDao orderDao=new OrderDaoImpl();
    private OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
    private UserDao userDao=new UserDaoImpl();
    private TransactionManager tm=new TransactionManager();
    @Override
    public int addOrder(Integer uid, List<Book> books) {
        int orderNo=0;
        try{
            tm.start();
            float sum=0;
            for(int i=0;i<books.size();i++){
                Book temp=books.get(i);
                Book book=bookDao.selectById(temp.getId());
                if(book==null){
                    throw new RuntimeException("图书【"+temp.getId()+"】不存在");
                }
                temp.setPrice(book.getPrice());
                sum+=book.getPrice()*temp.getCount();
            }
            Order order=new Order();
            order.setUid(uid);
            order.setSummary(sum);
            order.setAddress("test address");
            int ret=orderDao.insert(order);
            orderNo=ret;
            if(ret==0){
                throw new RuntimeException("订单添加失败");
            }
            OrderDetail detail=new OrderDetail();
            detail.setOid(ret);
            for(Book temp:books){
                detail.setBid(temp.getId());
                detail.setQuantity(temp.getCount());
                detail.setPrice(temp.getPrice().floatValue());
                ret=orderDetailDao.insert(detail);
                if(ret==0){
                    throw new RuntimeException("订单详情添加失败");
                }
                ret=bookDao.updateCount(temp.getId(),temp.getCount());
                if(ret==0){
                    throw new RuntimeException("图书【"+temp.getId()+"】库存不足");
                }
            }
            ret=userDao.updateScore(uid,(int)sum*(-1));
            if(ret==0){
                throw new RuntimeException("用户积分修改失败");
            }
            tm.commit();
            return orderNo;
        }
        catch (RuntimeException re){
            tm.rollback();
            throw  re;
        }
    }

    @Override
    public int deleteOrder(Order order) {
        int ret=0;
        try{
            tm.start();
            Order temp=orderDao.selectByIdUser(order.getOid(),order.getUid());
            if(temp==null){
                throw new RuntimeException("无此订单");
            }
            ret=userDao.updateScore(order.getUid(),(int)temp.getSummary().floatValue());
            if(ret==0){
                throw new RuntimeException("用户积分不足");
            }
            List<OrderDetail> ods=orderDetailDao.selectByOrder(temp.getOid());
            for (OrderDetail od : ods){
                ret=bookDao.updateCount(od.getBid(),-od.getQuantity());
                if(ret==0){
                    throw new RuntimeException("修改图书【"+od.getBid()+"】库存失败");
                }
            }
            ret=orderDetailDao.deleteByOrder(temp.getOid());
            if(ret!=ods.size()){
                throw new RuntimeException("删除订单详情失败");
            }
            ret=orderDao.delete(temp.getOid());
            if(ret==0){
                throw new RuntimeException("删除订单失败");
            }
            tm.commit();
            return ret;
        }
        catch (RuntimeException ex){
            tm.rollback();
            throw ex;
        }

    }

    @Override
    public List<Order> getByUser(Integer uid) {
        return orderDao.selectByUser(uid);
    }
}
