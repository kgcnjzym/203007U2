package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 动态SQL测试3
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/21 08:57
 * @since V1.00
 */
public class Test7 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession(true)){
            UserDao dao=session.getMapper(UserDao.class);
            User user=new User();
            user.setId(168);
//            user.setName("user1221-2");
//            user.setEmail("user1221-2@qq.com");
            user.setAge(21);
            int rt=dao.update2(user);
            System.out.println("rt="+rt);

        }
    }
}
