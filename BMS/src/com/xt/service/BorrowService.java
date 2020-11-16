package com.xt.service;

import com.xt.entity.vo.BorrowVo;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/13 10:22
 * @since V1.00
 */
public interface BorrowService {
    /**
     * 图书借阅：用户id、图书id
     * 1.验证图书id：存在且库存满足
     * 2.添加借阅记录
     * 3.修改图书库存
     * @return
     */
    int lend(Integer uid,Integer bid);

    List<BorrowVo> getByUser(Integer uid);
    List<BorrowVo> getAll();

    /**
     * 归还图书：用户id、图书id
     * 1.修改归还时间
     * 2.修改图书库存
     * 3.增加用户积分
     * 4.检查是否超期，如果是则添加罚金记录
     * @param uid
     * @param bid
     * @return
     */
    int returnBook(Integer uid,Integer bid);
}
