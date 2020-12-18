package test;

import com.xt.dao.OrderDao;
import com.xt.entity.vo.OrderVo;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 关联映射综合测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 08:57
 * @since V1.00
 */
public class Test3 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            OrderDao dao=session.getMapper(OrderDao.class);
            List<OrderVo> vos=dao.selectVosByUser(1);
            System.out.println(vos.size());
            System.out.println(vos);


        }
    }
}
