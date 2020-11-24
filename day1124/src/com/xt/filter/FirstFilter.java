package com.xt.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 一个简单的过滤器示例
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/24 08:57
 * @since V1.00
 */
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before FirstFilter doFilter....");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("After FirstFilter doFilter....");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy....");
    }
}
