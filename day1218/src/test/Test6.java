package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 动态SQL测试2
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/21 08:57
 * @since V1.00
 */
public class Test6 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
//            Map<String,Integer> ages=new HashMap<>();
//            ages.put("minAge",23);
//            ages.put("maxAge",23);
//            List<User> users=dao.selectByAges(ages);
            List<User> users=dao.selectByAges2(22,21);
            System.out.println(users.size());

        }
    }
}
