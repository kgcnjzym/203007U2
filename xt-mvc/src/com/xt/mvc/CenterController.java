package com.xt.mvc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 中央控制器
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/31 09:00
 * @since V1.00
 */
public class CenterController extends HttpServlet {
    private Map<String,Action> actions;
    private String actionFileName="actions.properties";
    private String prefix="/WEB-INF";
    private String suffix=".jsp";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径
        String path=req.getServletPath();
        Action action=actions.get(path);
        if(action==null){
            resp.sendError(404,"Action Not Found");
        }
        else{
            String ret=action.doAction(req,resp);
            if(ret!=null){
                if(ret.startsWith("redirect:")){
                    //重定向
                    String url=ret.substring(9);
                    resp.sendRedirect(url);
                }
                else{
                    //转发
                    req.getRequestDispatcher(prefix+ret+suffix).forward(req,resp);
                }
            }
            else{
                //AJAX请求，不跳转
            }

        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String value=config.getInitParameter("prefix");
        if(value!=null && !value.trim().equals("")) {
            prefix=value;
        }
        value=config.getInitParameter("suffix");
        if(value!=null && !value.trim().equals("")) {
            suffix=value;
        }
        value=config.getInitParameter("actionFileName");
        if(value!=null && !value.trim().equals("")) {
            actionFileName=value;
        }
        InputStream is=null;
        Properties props=new Properties();
        actions=new HashMap<>();
        try {
            is=CenterController.class.getClassLoader().getResourceAsStream(actionFileName);
            props.load(is);
            Set keys=props.keySet();
            for(Object k:keys) {
                String key=(String)k;
                String actionClass=props.getProperty(key);
                Action action = (Action) Class.forName(actionClass).newInstance();
                actions.put(key, action);
            }
        }catch(Exception ex){}
        finally {
            try {
                is.close();
            } catch (Exception e) {}
        }

    }
}
