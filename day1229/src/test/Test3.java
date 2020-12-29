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
public class Test3 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring3.xml");
        UserService service=ctx.getBean(UserService.class);
//        User user=service.getById(1000);
//        System.out.println("main:"+user);
        User temp=new User();
        temp.setName("user1229-4");
        temp.setEmail("u1229-4@qq.com");
        temp.setPhone("18812349872");
        try {
            int ret = service.reg(temp);
            System.out.println("ret=" + ret);
            System.out.println(temp);
        }
        catch (Exception e){
            System.out.println(e);
        }
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
