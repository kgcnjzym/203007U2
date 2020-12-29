package test;

import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 10:03
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring.xml");
        UserService service=ctx.getBean(UserService.class);
        User user=new User();
        user.setId(1);
        try {
            int ret = service.reg(user);
            System.out.println(ret);
        }catch (Exception e){
            System.out.println("main:"+e);
        }
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
