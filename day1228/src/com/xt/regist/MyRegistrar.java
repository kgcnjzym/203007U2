package com.xt.regist;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.定义注册器
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 10:16
 * @since V1.00
 */
public class MyRegistrar implements PropertyEditorRegistrar {
    private String format;
    public MyRegistrar(String format){
        this.format=format;
    }
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        CustomDateEditor cde=new CustomDateEditor(
                new SimpleDateFormat(format),true);
        registry.registerCustomEditor(Date.class,cde);
    }
}
