package com.xt.servlet;

import com.alibaba.fastjson.JSON;
import com.xt.entity.JsonData;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/25 10:38
 * @since V1.00
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp) throws ServletException, IOException {
        JsonData<String> data=new JsonData<>();
        if(ServletFileUpload.isMultipartContent(req)){
            ServletFileUpload upload=new ServletFileUpload(
                    new DiskFileItemFactory()
            );
            try {
                List<FileItem> items=upload.parseRequest(req);
                for(int i=0;items!=null && i<items.size();i++){
                    FileItem item=items.get(i);
                    if(! item.isFormField()){
                        if(item.getSize()>1024000){
                            data.setErrorCode(100);
                            data.setMessage("file size over 1000K");
                        }
                        else {
                            ServletContext ctx = getServletContext();
                            String path = ctx.getRealPath("/imgs");
                            File filePath = new File(path);
                            if (!filePath.exists()) {
                                filePath.mkdirs();
                            }
                            File target = new File(filePath, item.getName());
                            item.write(target);
                            data.setData("imgs/" + item.getName());
                            data.setMessage("upload ok");
                        }
                    }
                    else{
                        System.out.println(item.getFieldName()+":"+item.getString("UTF-8"));
                    }
                }
            } catch (Exception e) {
                data.setErrorCode(1);
                data.setMessage(e.getMessage());
            }
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out=resp.getWriter();
            out.write(JSON.toJSONString(data));
            out.close();
        }

    }


}
