package test;

import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/30 09:38
 * @since V1.00
 */
public class Test3 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring2.xml");
        UserService service=ctx.getBean(UserService.class);
        List<User> users=service.getByPage(-1,10);
        System.out.println(users.size());
        System.out.println(users);
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
