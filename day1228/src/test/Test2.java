package test;

import com.xt.entity.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 08:43
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring.xml");
        Order order=ctx.getBean(Order.class);
        System.out.println(order);
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
