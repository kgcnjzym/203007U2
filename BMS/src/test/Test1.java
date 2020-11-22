package test;

import com.xt.entity.Book;
import com.xt.service.OrderService;
import com.xt.service.impl.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 09:33
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        OrderService service=new OrderServiceImpl();
        List<Book> books=new ArrayList<>();
        Book bk=new Book();
        bk.setId(1);
        bk.setCount(2);
        books.add(bk);
        bk=new Book();
        bk.setId(3);
        bk.setCount(1);
        books.add(bk);
        bk=new Book();
        bk.setId(12);
        bk.setCount(1);
        books.add(bk);
        try{
            int ret=service.addOrder(1,books);
            System.out.println("添加成功，订单编号："+ret);
        }
        catch (RuntimeException ex){
            System.out.println(ex);
        }
    }
}
