package test;

import com.xt.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 08:43
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring.xml");
        User user1=ctx.getBean("u1",User.class);
        System.out.println(user1);
        User user2=(User)ctx.getBean("u2");
        System.out.println(user2);
        User user3=(User)ctx.getBean("u3");
        System.out.println(user3);
        User user4=ctx.getBean("u4",User.class);
        System.out.println(user4);
        User user5=ctx.getBean("u5",User.class);
        System.out.println(user5);
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
