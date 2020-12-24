package test;

import com.xt.factory.XmlBeanFactory;
import com.xt.service.UserService;
import com.xt.service.impl.UserServiceImpl;

/**
 * 自定义仿Spring框架测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 09:16
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        UserService service= XmlBeanFactory.getObject(UserServiceImpl.class);
        System.out.println(service);
        System.out.println(service.count());
    }
}
