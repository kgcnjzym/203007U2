package com.xt.util.jdbc;

import java.sql.Connection;

/**
 * 事务管理器
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 09:14
 * @since V1.00
 */
public class TransactionManager {
    /**
     * 开启手动事务
     */
    public void start(){
        Connection conn=DataBaseUtil.getConnection();
        try{
            conn.setAutoCommit(false);
        }
        catch (Exception ex){}
    }

    /**
     * 提交事务
     */
    public void commit(){
        Connection conn=DataBaseUtil.getConnection();
        try{
            conn.commit();
        }
        catch (Exception ex){}
        finally {
            DataBaseUtil.closeConnection();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        Connection conn=DataBaseUtil.getConnection();
        try{
            conn.rollback();
        }
        catch (Exception ex){}
        finally {
            DataBaseUtil.closeConnection();
        }
    }
}
