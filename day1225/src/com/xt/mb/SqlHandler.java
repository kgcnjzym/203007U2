package com.xt.mb;

import com.xt.util.jdbc.JdbcTemplate;
import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 09:36
 * @since V1.00
 */
public class SqlHandler implements InvocationHandler {
    private JdbcTemplate template=new JdbcTemplate();
    private static Logger logger=Logger.getRootLogger();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Annotation[] annos=method.getDeclaredAnnotations();
        if(annos==null || annos.length==0) {
            return null;
        }
        for(Annotation an:annos){
            if(an.annotationType()==Select.class){
                Select sel=method.getAnnotation(Select.class);
                String sql=sel.value();
                //获取返回值类型
                Class<?> retType=method.getReturnType();
                logger.debug("-->"+sql);
                logger.debug("-->"+Arrays.toString(args));
                Object ret;
                try {
                    //测试返回值类型是否为List，如果不是会产生异常
                    retType.asSubclass(List.class);
                    try {
                        //获取返回值的泛型类型
                        Type type = method.getGenericReturnType();
                        //获取泛型类型的Type:List<User> Map<String,Object>
                        Type geneType = ((ParameterizedType) type).getActualTypeArguments()[0];
                        //根据Type获取泛型类型
                        Class<?> geneClz = Class.forName(geneType.getTypeName());
                        ret = template.queryList(sql, geneClz, args);
                    }
                    catch (Exception ex){
                        throw ex;
                    }
                }
                catch(Exception ex){
                    ret = template.queryOne(sql, retType, args);
                }
                logger.debug("<--"+ret);
                return ret;
            }
            else if(an.annotationType()==Insert.class){
                Insert sel=method.getAnnotation(Insert.class);
                String sql=sel.value();
                int ret=template.update(sql,true,args);
                return ret;
            }
        }
        return null;
    }
}
