package com.xt.dao;

import com.xt.entity.Penalty;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/16 09:57
 * @since V1.00
 */
public interface PenaltyDao {
    /**
     * 添加罚金记录
     * @param penalty
     * @return
     */
    int insert(Penalty penalty);
}
