package com.xt.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/25 09:51
 * @since V1.00
 */
public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        HttpSession session=hse.getSession();
        String name=(String)session.getAttribute("name");
        ServletContext app=session.getServletContext();
        List<String> users=(List<String>)app.getAttribute("users");
        if(users!=null && name!=null){
            users.remove(name);
        }


    }
}
