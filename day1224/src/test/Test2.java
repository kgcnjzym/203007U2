package test;

import com.xt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 11:04
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring.xml");
//        UserService service= (UserService) ctx.getBean("userservice");
        UserService service=ctx.getBean(UserService.class);
        System.out.println(service.count());
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
