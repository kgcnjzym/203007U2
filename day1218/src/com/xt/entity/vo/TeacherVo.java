package com.xt.entity.vo;

import com.xt.entity.Course;
import com.xt.entity.Teacher;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 10:03
 * @since V1.00
 */
@Data
@ToString(callSuper = true)
public class TeacherVo extends Teacher {
    private List<Course> courses;
}
