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
public class Test3 {
    public static void main(String[] args) {
//        Ink ink=new ColorInk();
//        Paper paper=new A4Paper();
//        Printer pt=new Printer();
//        pt.setInk(ink);
//        pt.setPaper(paper);
//        pt.print();
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("printer.xml");
        Printer pt= (Printer) ctx.getBean("pt");
        pt.print();
        ((AbstractApplicationContext)ctx).close();
    }
}
