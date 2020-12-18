package com.xt.entity.vo;

import com.xt.entity.Book;
import lombok.Data;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 14:38
 * @since V1.00
 */
@Data
public class BookVo extends Book {
    private List<UserVo> users;
}
