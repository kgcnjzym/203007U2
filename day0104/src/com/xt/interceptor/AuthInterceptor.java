package com.xt.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

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
//        System.out.println("preHandle in AuthInterceptor,o.getClass="+o.getClass());
        //静态资源不拦截
        if(o.getClass()== DefaultServletHttpRequestHandler.class){
            return true;
        }
        //判断是否为AJAX请求
        boolean isAjax=false;
        HandlerMethod hm=(HandlerMethod)o;
        Method mth=hm.getMethod();
        Annotation anno=mth.getAnnotation(ResponseBody.class);
        if(anno!=null){
            isAjax=true;
        }
        else{
            Class<?> clz=mth.getDeclaringClass();
            anno=clz.getAnnotation(ResponseBody.class);
            if(anno!=null){
                isAjax=true;
            }
            else{
                isAjax=clz.getAnnotation(RestController.class)!=null;
            }
        }

        HttpSession session=req.getSession(false);
        if(session==null ||
                session.getAttribute("user")==null){
            if(isAjax){
                resp.setContentType("application/json;charset=UTF-8");
                PrintWriter out=resp.getWriter();
                out.write("{\"errorCode\":10,\"message\":\"请先登录\"}");
                out.close();
            }
            else {
                req.setAttribute("msg", "请先登录");
                req.getRequestDispatcher("/loginform").forward(req, resp);
            }
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
