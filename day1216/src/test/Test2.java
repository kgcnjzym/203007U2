package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MyBatis简单示例测试:使用DAO接口进行读操作
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/16 09:57
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        InputStream is=null;
        SqlSessionFactoryBuilder builder=null;
        SqlSessionFactory factory=null;
        SqlSession session=null;
        try {
            is= Test2.class.getClassLoader().getResourceAsStream("config.xml");
            builder=new SqlSessionFactoryBuilder();
            factory = builder.build(is);
            session = factory.openSession();
            //通过动态代理模式得到接口的实现类对象
            UserDao dao=session.getMapper(UserDao.class);
            System.out.println(dao.getClass());
            int rt=dao.getCount();
            System.out.println("rt="+rt);
            User user=dao.selectById(1);
            System.out.println(user);
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
