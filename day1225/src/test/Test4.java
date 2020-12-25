package test;

import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 11:17
 * @since V1.00
 */
public class Test4 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring.xml");
        UserService service=ctx.getBean(UserService.class);
        try {
            User temp = service.getUser(2);
            System.out.println(temp);
        }catch(Exception ex){
            System.out.println("ex in main");
        }

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
