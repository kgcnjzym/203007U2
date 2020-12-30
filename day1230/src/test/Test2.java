package test;

import com.xt.entity.City;
import com.xt.service.CityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/30 09:38
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("spring2.xml");
        CityService service=ctx.getBean(CityService.class);
        City city=service.getById(1);
        System.out.println(city);
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
