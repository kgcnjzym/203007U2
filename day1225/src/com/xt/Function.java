package com.xt;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 08:47
 * @since V1.00
 */
public class Function implements FuncInterface {
    @Override
    public Integer func1(String str){
        System.out.println("in func1:str="+str);
        return str.length();
    }
}
