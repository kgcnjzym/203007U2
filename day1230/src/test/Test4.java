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
public class Test4 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring2.xml");
        UserService service=ctx.getBean(UserService.class);
        User temp=new User();
        temp.setName("user1230-2");
        temp.setEmail("u1230-2@qq.com");
        temp.setPhone("18812349881");
        temp.setId(179);
        try{
            int ret=service.reg(temp);
            if(ret>0){
                System.out.println(temp);
            }
            else{
                System.out.println("fail");
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
