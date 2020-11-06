package com.xt.util.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC连接工具类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 08:50
 * @since V1.00
 */
public class DataBaseUtil {
    private static Properties properties;
    /**
     * 本地线程容器：确保同一线程中使用相同的连接对象
     */
    private static ThreadLocal<Connection> local=null;
    static{
        local=new ThreadLocal<>();
        properties=new Properties();
        InputStream is=null;
        try{
            is=DataBaseUtil.class.getClassLoader().
                    getResourceAsStream("db.properties");
            properties.load(is);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection conn=local.get();
        try {
            if(conn==null) {
                Class.forName(properties.getProperty("driver"));
                conn = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties);
                local.set(conn);
            }
            return conn;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源，如果是自动提交事务则关闭连接
     * @param stmt
     * @param rs
     */
    public static void closeQuietly(Statement stmt,
                                    ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            stmt.close();
        } catch (Exception e) {
        }
        Connection conn=DataBaseUtil.getConnection();
        try {
            if (conn.getAutoCommit()) {
                closeConnection();
            }
        }catch (Exception ex){}
    }

    /**
     * 关闭连接：在手动提交模式下提供给事务管理器的提交、回滚方法使用
     * 在自动提交模式下提供给closeQuietly使用
     */
    public static void closeConnection(){
        Connection conn=local.get();
        try {
            conn.close();
        } catch (Exception e) {
        }
        try {
            local.remove();
        } catch (Exception e) {
        }

    }

}
