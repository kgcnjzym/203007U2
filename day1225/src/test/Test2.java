package test;

import com.xt.dao.UserDao;
import com.xt.mb.SqlSession;

/**
 * 仿MyBatis测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 09:49
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        UserDao dao= SqlSession.getDao(UserDao.class);
//        System.out.println(dao.getClass());
//        User user=dao.selectById(1);
//        System.out.println(user);
//
//        List<User> us=dao.selectPage(0,3);
//        System.out.println(us);

        int ret=dao.insert("user1225","user1225@qq.com","18812345678");
        System.out.println(ret);
    }
}
