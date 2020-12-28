package com.xt.support;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 1.定义数据类型转换支持器类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 09:59
 * @since V1.00
 */
public class MyDateSupport extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
        try {
            super.setValue(fmt.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
            throw  new IllegalArgumentException("日期格式不符合yyyy-MM-dd");
        }
    }
}
