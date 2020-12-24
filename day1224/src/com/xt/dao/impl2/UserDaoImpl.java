package com.xt.dao.impl2;

import com.xt.dao.UserDao;
import org.apache.log4j.Logger;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 09:13
 * @since V1.00
 */
public class UserDaoImpl implements UserDao {
    private static Logger logger=Logger.getRootLogger();
    @Override
    public int selectCount() {
        logger.debug("selectCount in com.xt.dao.impl2.UserDaoImpl");
        return 20;
    }
}
