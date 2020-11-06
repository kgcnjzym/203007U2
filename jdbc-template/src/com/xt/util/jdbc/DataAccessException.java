package com.xt.util.jdbc;

/**
 * 自定义数据库操作访问异常类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 09:19
 * @since V1.00
 */
public class DataAccessException extends RuntimeException {
    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException() {
        super("数据库操作异常");
    }
}
