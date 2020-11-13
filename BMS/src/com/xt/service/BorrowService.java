package com.xt.service;

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
}
