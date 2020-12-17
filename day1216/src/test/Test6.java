package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Properties;

/**
 * Properties加载顺序测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/16 09:57
 * @since V1.00
 */
public class Test6 {
    public static void main(String[] args) {
        InputStream is=null;
        SqlSessionFactoryBuilder builder=null;
        SqlSessionFactory factory=null;
        SqlSession session=null;
        Properties properties=new Properties();
        properties.setProperty("password","123456");
        try {
            is= Test6.class.getClassLoader().getResourceAsStream("config.xml");
            builder=new SqlSessionFactoryBuilder();
            factory = builder.build(is,properties);
            session = factory.openSession();
            int rt = session.selectOne("com.xt.dao.UserDao.getCount");
            System.out.println("rt=" + rt);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                session.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
