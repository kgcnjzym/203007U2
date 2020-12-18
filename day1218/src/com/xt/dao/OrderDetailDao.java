package com.xt.dao;

import com.xt.entity.vo.OrderDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 13:33
 * @since V1.00
 */
public interface OrderDetailDao {
    /**
     * 根据订单ID查找详情VO
     * @param oid
     * @return
     */
    List<OrderDetailVo> selectDetailVosByOrder(Integer oid);

    /**
     * 根据图书id、用户id查询该用户购买该图书的总数量
     * @param bid
     * @param uid
     * @return
     */
    Integer selectSummary(@Param("bid") Integer bid,
                          @Param("uid") Integer uid);
}
