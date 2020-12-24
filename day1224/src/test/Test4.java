package test;

import com.xt.pt.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 11:43
 * @since V1.00
 */
public class Test4 {
    public static void main(String[] args) {
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("printer.xml");
        Printer pt1=  ctx.getBean(Printer.class);
        Printer pt2= ctx.getBean(Printer.class);
        System.out.println("pt1:"+pt1.hashCode());
        System.out.println("pt2:"+pt2.hashCode());

        ((AbstractApplicationContext)ctx).close();
    }
}
