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
public class Test4 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring4.xml");
        UserService service=ctx.getBean(UserService.class);
        System.out.println("service:"+service.getClass());
        User temp=new User();
        temp.setName("user1230-1");
        temp.setEmail("u1230-1@qq.com");
        temp.setPhone("18812349880");
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
