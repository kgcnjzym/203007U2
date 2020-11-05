package test;

import com.xt.dao.UserDao;
import com.xt.dao.impl.UserDaoImpl;
import com.xt.entity.User;
import com.xt.util.jdbc.DataBaseUtil;

/**
 * UserDao测试insert
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 09:44
 * @since V1.00
 */
public class Test4 {
    public static void main(String[] args) {
        User user=new User();
        user.setId(9);
        user.setName("李四");
        user.setPassword("123456");
        user.setAge(22);
        user.setGender("M");
        user.setPhone("13099988877");
        UserDao dao=new UserDaoImpl();
        int ret=dao.insert(user);
        System.out.println("ret="+ret);
    }
}
