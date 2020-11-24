package com.xt.listener;

import javax.servlet.*;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/24 12:16
 * @since V1.00
 */
public class ApplicationListener  implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("添加数据");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("删除数据");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("修改数据");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("应用程序启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("应用程序停止");
    }
}
