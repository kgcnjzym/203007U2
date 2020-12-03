package com.xt.servlet;

import com.alibaba.fastjson.JSON;
import com.xt.dao.CityDao;
import com.xt.dao.impl.CityDaoImpl;
import com.xt.entity.City;
import com.xt.entity.JsonData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/2 08:42
 * @since V1.00
 */
@WebServlet("/city.do")
public class CityServlet extends HttpServlet {
    private CityDao dao=new CityDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        String str="";
        String op=req.getParameter("op");
        JsonData<List<City>> data=new JsonData<>();
        String cb=req.getParameter("callback");

        if("cas".equals(op)){
            int up=0;
            try {
                up=Integer.parseInt(req.getParameter("up"));
                List<City> cts = dao.selectByUp(up);
                if( cts.size()==0){
                    data.setErrorCode(2);
                    data.setMessage("查无数据");
                }
                else {
                    data.setData(cts);
                    data.setMessage("OK");
                }
            }
            catch (Exception ex){
                data.setErrorCode(1);
                data.setMessage(ex.getMessage());
            }
            str= JSON.toJSONString(data);
            if(cb!=null && !cb.trim().equals("")){
                str=cb+"("+str+")";
            }
        }
        else if("auto".equals(op)){
            String ename=req.getParameter("key");
            List<City> cts=dao.selectByEname(ename);
            if( cts.size()==0){
                data.setErrorCode(2);
                data.setMessage("查无数据");
            }
            else {
                data.setData(cts);
                data.setMessage("OK");
            }
            str= JSON.toJSONString(data);
        }
        out.write(str);
        out.close();
    }
}
