package com.xt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/24 11:18
 * @since V1.00
 */
public class AuthFilter implements Filter {
    private String redirectURL="";
    private String sessionAttrName="";
    private boolean redirect=true;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String val=filterConfig.getInitParameter("RedirectURL");
        redirectURL=val;
        val=filterConfig.getInitParameter("SessionAttrName");
        sessionAttrName=val;
        val=filterConfig.getInitParameter("Redirect");
        try{
            redirect=Boolean.parseBoolean(val);
        }
        catch (Exception ex){}
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        HttpSession session=req.getSession(false);
        if(session==null){
            if(redirect) {
                resp.sendRedirect(redirectURL);
            }
            else{
                req.getRequestDispatcher(redirectURL).forward(req,resp);
            }
            return;
        }
        Object user=session.getAttribute(sessionAttrName);
        if(user==null){
            if(redirect) {
                resp.sendRedirect(redirectURL);
            }
            else{
                req.getRequestDispatcher(redirectURL).forward(req,resp);
            }
            return;
        }
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
