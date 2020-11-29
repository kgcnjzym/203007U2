package com.xt.listener;

import com.xt.entity.Paginate;
import com.xt.util.jdbc.DataBaseUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/25 08:45
 * @since V1.00
 */
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String value=servletContextEvent.getServletContext().getInitParameter("DBPOOL_TYPE");
        if(value!=null && !value.trim().equals("")) {
            DataBaseUtil.DBPOOL_TYPE = value;
        }
        value=servletContextEvent.getServletContext().getInitParameter("GROUP_SIZE");
        try{
            Paginate.GROUP_SIZE=Integer.parseInt(value);
        }
        catch (Exception ex){}
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
