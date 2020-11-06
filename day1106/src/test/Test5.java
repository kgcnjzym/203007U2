package test;

import com.xt.dao.BookDao;
import com.xt.dao.impl.BookDaoImpl;
import com.xt.entity.Book;

import java.util.List;

/**
 * BookDao测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 11:16
 * @since V1.00
 */
public class Test5 {
    public static void main(String[] args) {
        BookDao dao=new BookDaoImpl();
//        Book bk=dao.selectById(19);
//        System.out.println(bk);
        List<Book> bks=dao.selectByName("java");
        bks.stream().forEach(System.out::println);
    }
}
