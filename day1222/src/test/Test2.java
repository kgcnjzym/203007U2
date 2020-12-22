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
public class Test2 {

    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession(true)){
            UserDao dao=session.getMapper(UserDao.class);
            User user=new User();
            user.setName("user1222-1");
            user.setEmail("user1222-1@qq.com");
            user.setPhone("18612345699");
            int rt=dao.insert(user);
            System.out.println("rt="+rt);
            System.out.println(user);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
