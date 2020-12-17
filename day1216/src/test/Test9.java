package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 模糊查询测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 09:57
 * @since V1.00
 */
public class Test9 {
    public static void main(String[] args) {

        try (SqlSession session=SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
//            List<User> us=dao.selectByName1("%an%");
//            System.out.println(us);
//            System.out.println(us.size());
//            User temp=new User();
//            temp.setName("a'n");
//            List<User> us=dao.selectByName2(temp);
//            System.out.println(us);
//            System.out.println(us.size());

            List<User> us=dao.selectByName5("a'n");
            System.out.println(us);
            System.out.println(us.size());
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
