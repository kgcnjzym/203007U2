package com.xt.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 子控制器
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/31 09:01
 * @since V1.00
 */
public interface Action {
    /**
     * 执行具体操作
     * @param req
     * @param resp
     * @return  跳转路径
     * @throws ServletException
     * @throws IOException
     */
    public String doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
}
