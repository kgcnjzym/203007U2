package com.xt.factory;

import com.xt.entity.User;
import org.apache.log4j.Logger;

/**
 * 实例工厂
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 09:37
 * @since V1.00
 */
public class InstanceUserFactory {
    private static Logger logger=Logger.getRootLogger();
    public User newInstance(Integer id,String name,String email){
        logger.info("使用实例工厂创建对象");
        return new User(id,name,email);
    }
}
