package com.xt.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 11:03
 * @since V1.00
 */
public class MyNameHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String str=resultSet.getString(s);
        return str==null?null:str.toUpperCase();
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String str=resultSet.getString(i);
        return str==null?null:str.toUpperCase();
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
