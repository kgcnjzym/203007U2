package test;

import com.xt.dao.CourseDao;
import com.xt.entity.Course;
import com.xt.entity.vo.CourseVo;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 1：1关联映射测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 08:57
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            CourseDao dao=session.getMapper(CourseDao.class);
            Course course=dao.selectById(1);
            System.out.println(course);
            CourseVo vo=dao.selectVoById(1);
            System.out.println(vo);

        }
    }
}
