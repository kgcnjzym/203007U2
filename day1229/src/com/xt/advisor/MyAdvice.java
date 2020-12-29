package com.xt.advisor;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 09:55
 * @since V1.00
 */
@Component
public class MyAdvice implements MethodBeforeAdvice {
    private static Logger logger=Logger.getRootLogger();
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.debug(method.getName()+"执行前，参数是："+ Arrays.toString(objects));
    }
}
