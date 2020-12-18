package com.xt.dao;

import com.xt.entity.Course;
import com.xt.entity.vo.CourseVo;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 08:55
 * @since V1.00
 */
public interface CourseDao {
    /**
     *
     * @param id
     * @return
     */
    Course selectById(Integer id);

    CourseVo selectVoById(Integer id);

    /**
     *
     * @param teacherId
     * @return
     */
    List<Course> selectCoursesByTeacher(Integer teacherId);
}
