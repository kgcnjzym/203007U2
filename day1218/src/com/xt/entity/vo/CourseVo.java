package com.xt.entity.vo;

import com.xt.entity.Course;
import com.xt.entity.Teacher;
import lombok.Data;
import lombok.ToString;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 08:59
 * @since V1.00
 */
@Data
@ToString(callSuper = true)
public class CourseVo extends Course {
    private Teacher teacher;

}
