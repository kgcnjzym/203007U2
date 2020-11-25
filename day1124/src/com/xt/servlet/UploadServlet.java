package com.xt.servlet;

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
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/25 10:38
 * @since V1.00
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(req)){
            ServletFileUpload upload=new ServletFileUpload(
                    new DiskFileItemFactory()
            );
            try {
                List<FileItem> items=upload.parseRequest(req);
                for(int i=0;items!=null && i<items.size();i++){
                    FileItem item=items.get(i);
                    if(item.isFormField()){
                        if(item.getFieldName().equals("desc")) {
                            req.setAttribute("desc",
                                    item.getString("UTF-8"));
                        }
                    }
                    else{
                        ServletContext ctx=getServletContext();
                        String path=ctx.getRealPath("/imgs");
                        File filePath=new File(path);
                        if(!filePath.exists()){
                            filePath.mkdirs();
                        }
                        File target=new File(filePath,item.getName());
                        item.write(target);
                        req.setAttribute("imgSrc","imgs/"+item.getName());
                    }
                }
                req.setAttribute("msg","ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            req.setAttribute("msg","不是文件上传");
        }
        req.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(req,resp);
    }

    /**
     * InputStream is=null;
     *         try{
     *             is=req.getInputStream();
     *             byte []bts=new byte[1000];
     *             int cnt=0;
     *             while((cnt=is.read(bts))!=-1){
     *                 String str=new String(bts,0,cnt);
     *                 System.out.print(str);
     *             }
     *         }
     *         catch (Exception ex){
     *             System.out.println(ex);
     *         }
     *         finally {
     *             is.close();
     *         }
     *
     */
}
