package com.xt.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 11:15
 * @since V1.00
 */
public class LoggerAdvice {
    private static Logger logger=Logger.getRootLogger();
    public void before(JoinPoint jp){
        logger.info("方法【"+jp.getSignature()+"】执行前,参数："+
                Arrays.toString(jp.getArgs()));
    }
    public void afterReturning(JoinPoint jp,Object ret){
        logger.info("方法【"+jp.getSignature()+"】正常执行后，返回值："+ret);
    }
    public void afterThrowing(JoinPoint jp,Exception ex) {
        logger.info("方法【"+jp.getSignature()+"】产生异常后，异常类型："+ex);
    }

    /**
     * 专门用于环绕增强的方法结构
     * @param pjp
     * @return
     * @throws Exception
     */
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        try{
            logger.info("[around]方法【"+pjp.getSignature()+"】执行前,参数："+
                    Arrays.toString(pjp.getArgs()));
            Object ret=pjp.proceed(pjp.getArgs());
            logger.info("[around]方法【"+pjp.getSignature()+"】正常执行后，返回值："+ret);
            return ret;
        }
        catch (Throwable ex){
            logger.info("[around]方法【"+pjp.getSignature()+"】产生异常后，异常类型："+ex);
            throw ex;
        }
    }
}
