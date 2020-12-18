package com.xt.entity.vo;

import com.xt.entity.Book;
import com.xt.entity.OrderDetail;
import lombok.Data;
import lombok.ToString;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 13:32
 * @since V1.00
 */
@Data
@ToString(callSuper = true)
public class OrderDetailVo extends OrderDetail {
    private Book book;
}
