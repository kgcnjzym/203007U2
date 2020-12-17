package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 语句测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 09:57
 * @since V1.00
 */
public class Test8 {
    public static void main(String[] args) {

        try (SqlSession session=SqlSessionUtil.getSqlSession()){
//            List<User> lst=session.selectList("com.xt.dao.UserDao.selectByAges",20,22);
//            System.out.println(lst.size());

            UserDao dao=session.getMapper(UserDao.class);

//            List<User> us=dao.selectByAge(20);
            List<User> us=dao.selectByAges(20,22);
            System.out.println(us);
            System.out.println(us.size());
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
