package com.xt.dao;

import com.xt.entity.Borrow;
import com.xt.entity.vo.BorrowVo;

import java.util.List;

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

    /**
     * 根据用户查找借阅记录
     * @param uid
     * @return
     */
    List<BorrowVo> selectByUser(Integer uid);

    /**
     * 查找所有借阅记录
     * @return
     */
    List<BorrowVo> selectAll();

    /**
     * 根据用户id、图书id查找借阅记录
     * @param uid
     * @param bid
     * @return
     */
    Borrow selectByUserBook(Integer uid,Integer bid);

    /**
     * 修改图书归还时间
     * @param uid
     * @param bid
     * @return
     */
    int updateReturnDate(Integer uid,Integer bid);


}
