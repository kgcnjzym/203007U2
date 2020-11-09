package com.xt.util.jdbc;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * 结果集反射类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/8 09:58
 * @since V1.00
 */
public class Row2Object {
    private static Logger logger=Logger.getRootLogger();
    /**
     * String : Class Name
     *      String: colName
     *      Method: setter
     */
    private static Map<String, Map<String,Method>>  methods=
            new HashMap<>();

    /**
     * 将ResultSet指向的当前记录转换为实体对象
     *  1.获取列名（Label）、列类型
     *  2.根据列名获取setter
     *  3.根据列类型获取Java的数据类型
     *  4.调用setter存入相应的属性中
     * @param rs        结果集
     * @param clz       目标对象类型
     * @param <T>       类型泛型
     * @return          实体对象
     */
    public static  <T> T convert(ResultSet rs,Class<T> clz){
        ResultSetMetaData rsmd=null;
        T obj=null;
        try{
            obj=clz.getConstructor().newInstance();
            rsmd=rs.getMetaData();
            for(int i=0;i<rsmd.getColumnCount();i++){
                String colLabel=rsmd.getColumnLabel(i+1);
                int type=rsmd.getColumnType(i+1);
                Object value=null;
                Method mth=getSetter(clz,colLabel);
                if(mth==null){
                    continue;
                }
                if (type== Types.CHAR || type==Types.VARCHAR){
                    value=rs.getString(colLabel);
                }
                else if(type==Types.INTEGER){
                    value=rs.getInt(colLabel);
                }
                else if(type==Types.FLOAT){
                    value=rs.getFloat(colLabel);
                }
                else if(type==Types.DOUBLE){
                    value=rs.getDouble(colLabel);
                }
                else if(type==Types.DATE || type==Types.TIMESTAMP
                        || type==Types.TIME ){
                    value=rs.getTimestamp(colLabel);
                }
                else if(type==Types.BIT){
                    value=rs.getBoolean(colLabel);
                }
                else{
                    value=rs.getObject(colLabel);
                }
                try {
                    mth.invoke(obj, value);
                }catch(Exception ex){}
            }
        }
        catch (Exception ex){
            logger.debug(ex.getMessage());
        }
        return obj;
    }

    /**
     * 根据列名获取相应的setter
     * @param clz          类型
     * @param colName      列名
     * @return
     */
    public static Method getSetter(Class<?> clz, String colName) {
        Map<String,Method> mths=methods.get(clz.getName());
        if(mths==null){
            mths=new HashMap<>();
            methods.put(clz.getName(),mths);
        }
        String methodName="set"+colName;
        Method mth=mths.get(colName);
        if(mth==null) {
            Method[] methods = clz.getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equalsIgnoreCase(methodName)) {
                    mth = methods[i];
                    mths.put(colName,mth);
                    break;
                }
            }
        }
        if(mth==null){
            logger.debug(colName+" not found matched setter!");
        }
        return mth;

    }


}
