package test;

import com.xt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 08:43
 * @since V1.00
 */
public class Test5 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring3.xml");
        UserService service=ctx.getBean(UserService.class);
        System.out.println(service);
        System.out.println(service.reg(null));
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
