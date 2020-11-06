package com.xt.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 08:39
 * @since V1.00
 */
public class JdbcTemplate {
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
     * 数据库写操作
     * @param sql
     * @return  受影响的记录数
     */
    public int update(String sql, Object...params){
        Connection conn=null;
        PreparedStatement stmt=null;
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.prepareStatement(sql);
            setParameters(stmt,params);
            return stmt.executeUpdate();
        }
        catch(Exception ex){
            throw new DataAccessException(ex.getMessage());
        }
        finally{
            DataBaseUtil.closeQuietly(stmt,null);
        }
    }

    private void setParameters(PreparedStatement stmt,Object...params){
        try {
            for(int i=0;i<params.length;i++){
                stmt.setObject(i+1,params[i]);
            }
        }
        catch(Exception ex){}
    }
}
