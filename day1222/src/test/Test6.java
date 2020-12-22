package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test6 {

    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            User temp=new User();
            temp.setName("an");
            temp.setEmail("qq");
            List<User> us=dao.selectByUser(temp);
            System.out.println(us.size());
            System.out.println("==========");
            us=dao.selectByAges(null,null);
            System.out.println(us.size());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
