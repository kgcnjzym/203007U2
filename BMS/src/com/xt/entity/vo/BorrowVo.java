package com.xt.entity.vo;

import com.xt.entity.Borrow;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/16 09:17
 * @since V1.00
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BorrowVo extends Borrow {
    private String userName;
    private String bookName;
}
