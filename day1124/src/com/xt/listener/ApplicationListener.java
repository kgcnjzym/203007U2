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
    public void attributeAdded(ServletContextAttributeEvent sce) {
        System.out.println("添加数据:"+sce.getName()+"="+sce.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent sce) {
        System.out.println("删除数据:"+sce.getName()+"="+sce.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent sce) {
        //value：新？旧？
        System.out.println("修改数据，旧值:"+sce.getName()+"="+sce.getValue());
        System.out.println("修改数据，新值:"+sce.getName()+"="+
                sce.getServletContext().getAttribute(sce.getName()));
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
