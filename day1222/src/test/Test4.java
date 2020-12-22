package test;

import com.xt.dao.OrderDao;
import com.xt.entity.Order;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test4 {

    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            OrderDao dao=session.getMapper(OrderDao.class);
            Order order=dao.selectById(2);
            System.out.println(order);


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
