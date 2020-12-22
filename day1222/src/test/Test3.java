package test;

import com.xt.dao.UserDao;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test3 {

    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession(true)){
            UserDao dao=session.getMapper(UserDao.class);
            int rt=dao.deleteById(170);
            System.out.println("rt="+rt);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
