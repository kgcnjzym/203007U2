package test;

import com.xt.entity.Book;
import com.xt.entity.User;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * 反射测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/8 10:20
 * @since V1.00
 */
public class Test3 {
    public static void main(String[] args) {
        JdbcTemplate temp=new JdbcTemplate();
        String sql="select bid id,bname name,author,pubcomp," +
                "pubdate,bcount count,price from book where bid=1";
        Book book=temp.queryOne(sql,Book.class);
        System.out.println(book);
        String sql2="select * from users where gender=?";
        List<User> us=temp.queryList(sql2,User.class,"M");
        us.stream().forEach(System.out::println);

    }
}
