package com.xt.factory;

import com.xt.entity.User;
import org.apache.log4j.Logger;

/**
 * 静态工厂：用于创建用户
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 09:33
 * @since V1.00
 */
public class StaticUserFactory {
    private static Logger logger=Logger.getRootLogger();
    public static User createUser(Integer id,String name,String email){
        logger.info("使用静态工厂创建对象");
        return new User(id,name,email);
    }
}
