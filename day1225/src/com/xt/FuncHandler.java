package com.xt;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 08:54
 * @since V1.00
 */
public class FuncHandler implements InvocationHandler {
    private Object target;
    public FuncHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法参数："+ Arrays.toString(args));
        Object ret=method.invoke(target,args);
        System.out.println("执行结果："+ret);
        return ret;
    }
}
