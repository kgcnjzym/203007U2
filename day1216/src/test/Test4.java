package test;

import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * SqlSession工具类测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 09:57
 * @since V1.00
 */
public class Test4 {
    public static void main(String[] args) {

        try (SqlSession session=SqlSessionUtil.getSqlSession()){
            int rt = session.selectOne("com.xt.dao.UserDao.getCount");
            System.out.println("rt=" + rt);
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
