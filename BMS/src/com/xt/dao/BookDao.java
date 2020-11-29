package com.xt.dao;


import com.xt.entity.Book;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 11:09
 * @since V1.00
 */
public interface BookDao {
    /**
     * 根据图书Id查找
     * @param id
     * @return
     */
    Book selectById(Integer id);

    /**
     * 根据图书名模糊查找
     * @param name
     * @return
     */
    List<Book> selectByName(String name);

    /**
     * 查找所有图书
     * @return
     */
    List<Book> selectAll();

    /**
     * 根据图书id及库存查找
     * @param bid
     * @return
     */
    int selectCountById(Integer bid);

    /**
     * 修改图书库存
     * @param bid
     * @param count
     * @return
     */
    int updateCount(Integer bid,int count);

    /**
     * 添加图书
     * @param book
     * @return
     */
    int insert(Book book);

    /**
     * 选择销量最大的N本图书编号
     * @param limit     N
     * @return
     */
    List<Book> selectTop(Integer limit);
}
