package com.xt.util.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 08:50
 * @since V1.00
 */
public class DataBaseUtil {
    private static Properties properties;
    static{
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
        Connection conn=null;
        try {
            Class.forName(properties.getProperty("driver"));
            conn = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties);
            return conn;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 释放JDBC资源
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void closeQuietly(Connection conn,
                                    Statement stmt,
                                    ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }

    }

    /**
     * 数据库读操作
     * @param conn
     * @param sql
     * @return      结果集对象
     */
    public static ResultSet query(Connection conn,String sql){
        Statement stmt=null;
        ResultSet rs=null;
        try{
            stmt=conn.createStatement();
            rs= stmt.executeQuery(sql);
            return rs;
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    /**
     * ?作为占位符，通过setXXX设置占位符的值
     * @param conn
     * @param sql
     * @param params
     * @return
     */
    public static ResultSet query(Connection conn,String sql,Object...params){
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            stmt=conn.prepareStatement(sql);
            stmt.setObject(1,params[0]);
            stmt.setObject(2,params[1]);
            rs= stmt.executeQuery();
            return rs;
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    /**
     * 数据库写操作
     * @param sql
     * @return  受影响的记录数
     */
    public static int update(String sql){
        Connection conn=null;
        Statement stmt=null;
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            return stmt.executeUpdate(sql);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        finally{
            closeQuietly(conn,stmt,null);
        }
        return 0;
    }

}
