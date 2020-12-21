package test;

import com.xt.dao.UserDao;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.List;

/**
 * 动态SQL测试4
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/21 08:57
 * @since V1.00
 */
public class Test8 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession(true)){
            UserDao dao=session.getMapper(UserDao.class);
            List<Integer> ids= Arrays.asList(133,126,132);
            int rt=dao.updateStates(ids,0,1);
            System.out.println("rt="+rt);

        }
    }
}
