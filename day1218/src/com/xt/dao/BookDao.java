package com.xt.dao;

import com.xt.entity.Book;
import com.xt.entity.vo.BookVo;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 13:33
 * @since V1.00
 */
public interface BookDao {
    /**
     * 根据图书ID查找图书
     * @param bid
     * @return
     */
    Book selectById(Integer bid);

    /**
     * 根据图书、用户统计销量
     * @return
     */
    List<BookVo> selectSellInfo();
}
