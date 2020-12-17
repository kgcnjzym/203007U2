package com.xt.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * SqlSession工具类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 08:48
 * @since V1.00
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory=null;
    public static String configFileName="config.xml";

    /**
     * 构建SqlSessionFactory对象
     */
    private static void init(){
        SqlSessionFactoryBuilder builder=
                new SqlSessionFactoryBuilder();
        InputStream is=null;
        try{
            is= Resources.getResourceAsStream(configFileName);
            factory=builder.build(is);
        }
        catch (Exception ex){
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
     * 默认手动事务
     * @return
     */
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    /**
     * 通过参数指定事务类型
     * @param autoCommit
     * @return
     */
    public static SqlSession getSqlSession(boolean autoCommit){
        SqlSession session=null;
        try{
            if(factory==null){
                init();
            }
            session=factory.openSession(autoCommit);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return session;
    }
}
