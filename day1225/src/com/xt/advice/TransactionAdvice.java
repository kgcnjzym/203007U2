package com.xt.advice;

import com.xt.util.jdbc.TransactionManager;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 事务增强
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 15:31
 * @since V1.00
 */
public class TransactionAdvice {
    private static Logger logger=Logger.getRootLogger();
    @Setter
    private TransactionManager tm;
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        try{
            tm.start();
            logger.info("已设置手动事务");
            Object ret=pjp.proceed(pjp.getArgs());
            tm.commit();
            logger.info("事务已提交");
            return  ret;
        }
        catch (Throwable ex){
            tm.rollback();
            logger.info("事务已回滚");
            throw  ex;
        }
    }
}
