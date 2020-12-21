package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态SQL测试4
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/21 08:57
 * @since V1.00
 */
public class Test9 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession(true)){
            UserDao dao=session.getMapper(UserDao.class);
            List<User> users= new ArrayList<>();
            users.add(new User(0,"www","sww@qq.qq",20));
            users.add(new User(0,"sss","ss@qq.qq",20));
            users.add(new User(0,"ttt","tt@qq.qq",20));
            users.add(new User(0,"uuu","uu@qq.qq",20));
            int rt=dao.insertUsers(users);
            System.out.println("rt="+rt);

        }
    }
}
