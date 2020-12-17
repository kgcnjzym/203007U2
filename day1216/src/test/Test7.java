package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 别名测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 09:57
 * @since V1.00
 */
public class Test7 {
    public static void main(String[] args) {

        try (SqlSession session=SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            User user=dao.selectById(1);
            System.out.println(user);
            List<User> us=dao.selectUsers(3);
            System.out.println(us);
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
