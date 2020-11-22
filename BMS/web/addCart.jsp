<%@ page import="java.util.Map" %>
<%@ page import="com.xt.entity.Book" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.xt.service.BookService" %>
<%@ page import="com.xt.service.impl.BookServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String op=request.getParameter("op");
    if("clear".equals(op)){
        session.removeAttribute("carts");
        request.setAttribute("msg","已清空购物车");
        request.getRequestDispatcher("carts.jsp").forward(request,response);
        return;
    }
    BookService service=new BookServiceImpl();
    Map<String, Book> carts=(Map<String, Book>)session.getAttribute("carts");
    if(carts==null){
        carts=new HashMap<>();
        session.setAttribute("carts",carts);
    }
    String bid=request.getParameter("bid");
    int id=0;
    try{
        id=Integer.parseInt(bid);
        Book book=service.getById(id);

        if("add".equals(op)){
            if(book==null){
                throw new RuntimeException("无此图书");
            }
            if(book.getCount()==0){
                throw new RuntimeException("图书无库存");
            }
            if(carts.containsKey(bid)){
                Book temp=carts.get(bid);
                if(book.getCount()>temp.getCount()) {
                    temp.setCount(temp.getCount() + 1);
                }
                else{
                    throw new RuntimeException("图书库存不足");
                }
            }
            else{
                Book temp=new Book();
                temp.setId(id);
                temp.setCount(1);
                carts.put(bid,temp);
            }
        }
        else if ("sub".equals(op)){
            if(book==null){
                throw new RuntimeException("无此图书");
            }
            Book temp=carts.get(bid);
            if(book.getCount()<temp.getCount()){
                temp.setCount(book.getCount());
                if(temp.getCount()==0) {
                    carts.remove(bid);
                    throw new RuntimeException("图书无库存,已从购物车中删除");
                }
                else{
                    request.setAttribute("msg","图书数量减少成功");
                }
            }
            else{
                temp.setCount(temp.getCount()-1);
                if(temp.getCount()==0) {
                    carts.remove(bid);
                    request.setAttribute("msg","图书从购物车中删除成功");
                }
                else{
                    request.setAttribute("msg","图书数量减少成功");
                }
            }
        }
        else if ("del".equals(op)){
            if(carts.remove(bid)!=null) {
                request.setAttribute("msg", "图书" + bid + "从购物车中删除成功");
            }else{
                request.setAttribute("msg", "购物车中无编号"+bid+"的图书");
            }
        }
        else if ("dels".equals(op)){
            String []ids=request.getParameterValues("bid");
            for (int i=0;i<ids.length;i++){
                carts.remove(ids[i]);
            }
            request.setAttribute("msg", "批量删除成功");
        }
    }
    catch(NumberFormatException ex){
        request.setAttribute("msg","图书编号错误！");

    }
    catch (RuntimeException re){
        request.setAttribute("msg",re.getMessage());
    }
    request.getRequestDispatcher("carts.jsp").forward(request,response);
%>
