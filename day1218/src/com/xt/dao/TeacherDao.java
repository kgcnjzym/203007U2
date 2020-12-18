package com.xt.dao;

import com.xt.entity.Teacher;
import com.xt.entity.vo.TeacherVo;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 09:10
 * @since V1.00
 */
public interface TeacherDao {

    /**
     *
     * @param id
     * @return
     */
    Teacher selectById(Integer id);

    /**
     *
     * @param id
     * @return
     */
    TeacherVo selectVoById(Integer id);
}
