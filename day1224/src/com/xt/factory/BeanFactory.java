package com.xt.factory;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 09:19
 * @since V1.00
 */
public class BeanFactory {
    private static Map<String,Object> objects;
    static {
        objects=new HashMap<>();
        InputStream is=null;
        try{
            Properties properties=new Properties();
            is=BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            properties.load(is);
            //对象创建
            for(Object k : properties.keySet()){
                String key=(String)k;
                String value=properties.getProperty(key);
                Object obj=Class.forName(value).newInstance();
                objects.put(key,obj);
            }
            //对象装配
            for(Object obj:objects.values()){
                Class<?> clz=obj.getClass();
                Method[] mths=clz.getMethods();
                for(int i=0;i<mths.length;i++){
                    String name=mths[i].getName();
                    if(name.startsWith("set")){
                        Class<?> paramType=mths[i].getParameterTypes()[0];
                        for(Object temp:objects.values()){
                            if(temp.getClass()==paramType){
                                mths[i].invoke(obj,temp);
                            }
                            else{
                                Class<?> []clsArr=temp.getClass().getInterfaces();
                                for(int j=0;clsArr!=null && j<clsArr.length;j++){
                                    if(clsArr[j]==paramType){
                                        mths[i].invoke(obj,temp);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex){

        }
        finally {
            try{
                is.close();
            }catch (Exception ex){}
        }
    }

    public static <T> T getObject(Class<T> cls){
        for(Object obj:objects.values()){
            if(obj.getClass()==cls){
                return (T)obj;
            }
        }
        return null;
    }

    public static Object getObject(String name){
        return objects.get(name);
    }
}
