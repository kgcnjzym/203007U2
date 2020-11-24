package com.xt.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器2：用于测试过滤器链
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/24 09:30
 * @since V1.00
 */
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter init....");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before SecondFilter doFilter....:name="+servletRequest.getParameter(
                "name"));
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("After SecondFilter doFilter....");

    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter destroy....");

    }
}
