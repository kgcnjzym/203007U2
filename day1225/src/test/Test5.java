package test;

import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 15:40
 * @since V1.00
 */
public class Test5 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring.xml");
        UserService service=ctx.getBean(UserService.class);
        System.out.println("service:"+service.getClass());
        try {
            User temp = new User();
            temp.setId(169);
            temp.setName("user1225-3");
            temp.setEmail("user1225-3@qq.com");
            temp.setPhone("18812345676");
            int ret=service.insert(temp);
            System.out.println(ret);
        }catch(Exception ex){
            System.out.println("ex in main:"+ex.getMessage());
        }

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
