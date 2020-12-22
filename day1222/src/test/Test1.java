package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test1 {

    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            User user=dao.queryById(1);
            System.out.println(user);
//            session.clearCache();
            System.out.println("==========");
            User user2=dao.queryById(1);
            System.out.println(user2);
//            List<User> us=dao.queryAll();
//            System.out.println(us.size());
//            System.out.println(us.get(0));

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("*****************");
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            User user=dao.queryById(1);
            System.out.println(user);
//            session.clearCache();
            System.out.println("==========");
            User user2=dao.queryById(1);
            System.out.println(user2);
//            List<User> us=dao.queryAll();
//            System.out.println(us.size());
//            System.out.println(us.get(0));

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
