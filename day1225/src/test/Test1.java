package test;

import com.xt.FuncHandler;
import com.xt.FuncInterface;
import com.xt.Function;

import java.lang.reflect.Proxy;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 08:48
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
//        Function f=new Function();
//        int rt=f.func1("hello");
//        System.out.println("rt="+rt);
        Function f=new Function();
        FuncInterface fi= (FuncInterface)Proxy.newProxyInstance(
                Test1.class.getClassLoader(),
                f.getClass().getInterfaces(),
                new FuncHandler(f));
        System.out.println(fi.getClass());
        Integer ret=fi.func1("hello");
        System.out.println("main:ret="+ret);
    }
}
