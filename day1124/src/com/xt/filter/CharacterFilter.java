package com.xt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/24 09:49
 * @since V1.00
 */
public class CharacterFilter implements Filter {
    private String encoding="UTF-8";
    private boolean enableGet=false;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String val=filterConfig.getInitParameter("Encoding");
        if(val!=null && !val.trim().equals("")){
            encoding=val;
        }
        val=filterConfig.getInitParameter("EnableGet");
        try{
            enableGet=Boolean.parseBoolean(val);
        }
        catch (Exception ex){}
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        if("post".equalsIgnoreCase(req.getMethod())) {
            servletRequest.setCharacterEncoding(encoding);
        }
        else if(enableGet && "get".equalsIgnoreCase(req.getMethod())){
            servletRequest=new EncodingServletRequest(req,encoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
