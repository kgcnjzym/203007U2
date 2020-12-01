package com.xt.servlet;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/30 08:55
 * @since V1.00
 */
@WebServlet("/second.do")
public class SecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        Document doc=new Document();
        Element root=new Element("root");
        doc.addContent(root);
        Element sub=new Element("sub");
        root.addContent(sub);
        sub.setAttribute("id","s1");
        Element name=new Element("name");
        name.setText("mike");
        sub.addContent(name);
        Element age=new Element("age");
        age.setText("23");
        sub.addContent(age);

        sub=new Element("sub");
        root.addContent(sub);
        sub.setAttribute("id","s2");
        name=new Element("name");
        name.setText("<tom>");
        sub.addContent(name);
        age=new Element("age");
        age.setText("24");
        sub.addContent(age);

        XMLOutputter outter=new XMLOutputter();
        outter.output(doc,out);
        out.close();
    }
}
