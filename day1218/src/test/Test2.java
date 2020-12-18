package test;

import com.xt.dao.TeacherDao;
import com.xt.entity.vo.TeacherVo;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 1:m 关联映射测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 08:57
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            TeacherDao dao=session.getMapper(TeacherDao.class);

            TeacherVo vo=dao.selectVoById(1);
            System.out.println(vo.getName());
            System.out.println("------------");
            System.out.println(vo.getCourses());

        }
    }
}
