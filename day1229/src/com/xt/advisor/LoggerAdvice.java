package com.xt.advisor;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 10:10
 * @since V1.00
 */
@Aspect
@Component
public class LoggerAdvice {
    private static Logger logger=Logger.getRootLogger();

    @Pointcut("execution(public * com.xt..*(..))")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint jp){
        logger.info("before method["+jp.getSignature()+
                "] execute,param:"+ Arrays.toString(
                        jp.getArgs()));
    }

    @AfterReturning(value = "pt()",returning = "ret")
    public void afterReturning(JoinPoint jp,Object ret){
        logger.info("after returning method["+jp.getSignature()+
                "] execute,result:"+ ret);
    }

    @AfterThrowing(value = "pt()",throwing = "ex")
    public void afterReturning(JoinPoint jp,Exception ex){
        logger.info("after throwing method["+jp.getSignature()+
                "] execute,ex:"+ ex);
    }


}
