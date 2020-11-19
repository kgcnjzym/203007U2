package test;

import com.xt.entity.User;
import com.xt.service.UserService;
import com.xt.service.impl.UserServiceImpl;

import java.util.Random;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/19 09:04
 * @since V1.00
 */
public class Test {
    public static void main(String[] args) {
        Random rnd=new Random();
        UserService service=new UserServiceImpl();
        for (int i=1;i<150;i++){
            User u=new User();
            u.setName("user"+i);
            u.setPassword("123456");
            u.setEmail("user"+i+"@qq.com");
            u.setGender(rnd.nextInt()%2==0?"M":"F");
            u.setAge(rnd.nextInt(20)+20);
            String phone="00000000"+rnd.nextInt(100000000);
            u.setPhone("189"+phone.substring(phone.length()-8));
            int ret=service.reg(u);
            System.out.println(ret);
        }
    }
}
