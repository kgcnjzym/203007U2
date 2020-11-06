package com.xt.util.jdbc;

import java.sql.ResultSet;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 09:59
 * @since V1.00
 */
public interface RowMapper<T> {
    /**
     * 将ResultSet指向的当前记录转换为实体对象
     * @param rs
     * @return
     */
    T convert(ResultSet rs);
}
