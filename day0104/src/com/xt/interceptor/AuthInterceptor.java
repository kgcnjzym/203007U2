package com.xt.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 访问控制拦截器
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/6 11:11
 * @since V1.00
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
                             Object o) throws Exception {
        System.out.println("preHandle in AuthInterceptor,o.getClass="+o.getClass());
        //静态资源不拦截
        if(o.getClass()== DefaultServletHttpRequestHandler.class){
            return true;
        }
        HttpSession session=req.getSession(false);
        if(session==null ||
                session.getAttribute("user")==null){
            req.setAttribute("msg","请先登录");
            req.getRequestDispatcher("/loginform").forward(req,resp);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle in AuthInterceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion in AuthInterceptor");
    }
}
