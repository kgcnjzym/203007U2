package test;

import com.xt.entity.Order;
import com.xt.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 08:43
 * @since V1.00
 */
public class Test3 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring1.xml");
        Order order=ctx.getBean(Order.class);
        System.out.println(order);
        User user=ctx.getBean(User.class);
        System.out.println(user);
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
