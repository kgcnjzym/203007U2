package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MyBatis简单示例测试:使用DAO接口进行写操作
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/16 09:57
 * @since V1.00
 */
public class Test3 {
    public static void main(String[] args) {
        InputStream is=null;
        SqlSessionFactoryBuilder builder=null;
        SqlSessionFactory factory=null;
        SqlSession session=null;
        try {
            is= Resources.getResourceAsStream("config.xml");
            builder=new SqlSessionFactoryBuilder();
            factory = builder.build(is);
//            设置参数true：将手动事务改为自动事务
            session = factory.openSession(true);
            //通过动态代理模式得到接口的实现类对象
            UserDao dao=session.getMapper(UserDao.class);
            User user=new User();
            user.setName("user1216-4");
            user.setPassword("123456");
            user.setEmail("user1216-4@qq.com");
            user.setPhone("18612345676");
            user.setPoint(10);
            int rt=dao.insert(user);
            System.out.println("rt="+rt);
            System.out.println("user="+user);

            //写操作默认是手动事务
//            if(rt>0) {
//                session.commit();
//            }

        }catch(Exception ex){
            session.rollback();
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
