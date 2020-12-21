package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 动态SQL测试1
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/21 08:57
 * @since V1.00
 */
public class Test5 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            User temp=new User();
//            temp.setName("an");
            temp.setEmail("tt");
            List<User> users=dao.selectByUser4(temp);
            System.out.println(users.size());

        }
    }
}
