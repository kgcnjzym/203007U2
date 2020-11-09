package com.xt.util.jdbc;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 08:39
 * @since V1.00
 */
public class JdbcTemplate {
    private static Logger logger=Logger.getRootLogger();
    /**
     * 标量查询示例
     * 标量scale：一条记录一个列
     * @param sql
     * @param clz
     * @param params
     * @param <T>
     * @return
     */
    public <T> T queryScale(String sql,Class<T> clz,Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.prepareStatement(sql);
            setParameters(stmt,params);
            rs= stmt.executeQuery();
            logger.debug("SQL Statement:"+sql);
            logger.debug("Parameters:"+ Arrays.toString(params));
            if(rs.next()) {
                if(clz==Integer.class){
                    return (T)(new Integer(rs.getInt(1)));
                }
                else if(clz==String.class){
                    return (T)(rs.getString(1));
                }
                else if(clz== Date.class){
                    return (T)(rs.getTimestamp(1));
                }
                else if(clz==Float.class){
                    return (T)(new Float(rs.getFloat(1)));
                }
                else if(clz==Double.class){
                    return (T)(new Double(rs.getDouble(1)));
                }
                else{
                    return (T)(rs.getObject(1));
                }
            }
            return null;
        }
        catch(Exception ex){
            throw new DataAccessException(ex.getMessage());
        }
        finally {
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }

    /**
     * 使用变长参数、记录映射对象将查询结果以实体对象形式返回
     * @param sql       查询语句
     * @param rm        记录映射对象
     * @param params    变长参数
     * @param <T>       实体对象类型
     * @return          实体对象
     */
    public <T> T queryOne(String sql,RowMapper<T> rm, Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.prepareStatement(sql);
            setParameters(stmt,params);
            rs= stmt.executeQuery();
            logger.debug("SQL Statement:"+sql);
            logger.debug("Parameters:"+ Arrays.toString(params));
            if(rs.next()) {
                return rm.convert(rs);
            }
            return null;
        }
        catch(Exception ex){
            throw new DataAccessException(ex.getMessage());
        }
        finally {
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }


    /**
     * 使用变长参数、类型反射将查询结果以实体对象形式返回
     * @param sql
     * @param clz
     * @param params
     * @param <T>
     * @return
     */
    public <T> T queryOne(String sql,Class<T> clz, Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.prepareStatement(sql);
            setParameters(stmt,params);
            rs= stmt.executeQuery();
            logger.debug("SQL Statement:"+sql);
            logger.debug("Parameters:"+ Arrays.toString(params));
            if(rs.next()) {
                return Row2Object.convert(rs,clz);
            }
            return null;
        }
        catch(Exception ex){
            throw new DataAccessException(ex.getMessage());
        }
        finally {
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }


    /**
     * 使用变长参数、记录映射对象将查询结果以实体对象集合形式返回
     * @param sql       查询语句
     * @param rm        记录映射对象
     * @param params    变长参数
     * @param <T>       实体对象类型
     * @return          实体对象集合
     */
    public <T> List<T> queryList(String sql, RowMapper<T> rm, Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<T> lst=new ArrayList<>();
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.prepareStatement(sql);
            setParameters(stmt,params);
            rs= stmt.executeQuery();
            logger.debug("SQL Statement:"+sql);
            logger.debug("Parameters:"+ Arrays.toString(params));
            while(rs.next()) {
               T temp=rm.convert(rs);
               lst.add(temp);
            }
            return lst;
        }
        catch(Exception ex){
            throw new DataAccessException(ex.getMessage());
        }
        finally {
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }

    /**
     * 使用变长参数、类型反射对象将查询结果以实体对象集合形式返回
     * @param sql
     * @param clz
     * @param params
     * @param <T>
     * @return
     */
    public <T> List<T> queryList(String sql, Class<T> clz, Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<T> lst=new ArrayList<>();
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.prepareStatement(sql);
            setParameters(stmt,params);
            rs= stmt.executeQuery();
            logger.debug("SQL Statement:"+sql);
            logger.debug("Parameters:"+ Arrays.toString(params));
            while(rs.next()) {
                T temp=Row2Object.convert(rs,clz);
                lst.add(temp);
            }
            return lst;
        }
        catch(Exception ex){
            throw new DataAccessException(ex.getMessage());
        }
        finally {
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }

    /**
     * 数据库写操作
     * @param sql       增删改语句
     * @param needInc   是否返回自增值
     * @param params    变长参数
     * @return          受影响的记录数或自增值
     */
    public int update(String sql, boolean needInc,Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameters(stmt,params);
            int ret=stmt.executeUpdate();
            logger.debug("SQL Statement:"+sql);
            logger.debug("Parameters:"+ Arrays.toString(params));
            if(sql.toUpperCase().startsWith("INSERT INTO ")
                    && needInc){
                rs=stmt.getGeneratedKeys();
                if(rs.next()){
                    ret=rs.getInt(1);
                    logger.debug("GeneratedKeys："+ret);
                }
                else{
                    logger.debug("Affected Rows："+ret);
                }
            }
            else{
                logger.debug("Affected Rows："+ret);
            }
            return ret;
        }
        catch(Exception ex){
            throw new DataAccessException(ex.getMessage());
        }
        finally{
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }

    private void setParameters(PreparedStatement stmt,Object...params){
        try {
            for(int i=0;i<params.length;i++){
                stmt.setObject(i+1,params[i]);
            }
        }
        catch(Exception ex){
            logger.warn(ex.getMessage());
        }
    }
}
