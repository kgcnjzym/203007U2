package com.xt.dao;

import com.xt.entity.Borrow;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/13 10:41
 * @since V1.00
 */
public interface BorrowDao {
    /**
     * 添加借阅记录
     * @param borrow
     * @return
     */
    int insert(Borrow borrow);
}
