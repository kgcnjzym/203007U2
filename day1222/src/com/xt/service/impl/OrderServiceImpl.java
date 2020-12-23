package com.xt.service.impl;

import com.xt.dao.OrderDao;
import com.xt.entity.vo.OrderVo;
import com.xt.service.OrderService;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/23 10:34
 * @since V1.00
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public List<OrderVo> getAll() {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            OrderDao dao=session.getMapper(OrderDao.class);
            return dao.selectAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
