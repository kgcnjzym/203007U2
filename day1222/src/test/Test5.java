package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test5 {

    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            User user=dao.selectVoById(1);
            System.out.println(user);


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
