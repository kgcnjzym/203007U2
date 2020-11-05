package test;

import com.xt.dao.UserDao;
import com.xt.dao.impl.UserDaoImpl;
import com.xt.entity.User;

import java.util.Scanner;

/**
 * UserDao测试selectUser
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 09:44
 * @since V1.00
 */
public class Test5 {
    public static void main(String[] args) {
        User user=new User();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String val=sc.nextLine();
        user.setName(val);
//        sc.nextLine();
        System.out.println("请输入密码：");
        val=sc.nextLine();
        user.setPassword(val);
        UserDao dao=new UserDaoImpl();
        User rt=dao.selectUser(user);
        if(rt==null){
            System.out.println("登陆失败");
        }
        else{
            System.out.println("用户["+rt+"]登陆成功！");
        }

    }
}
