package test;

import com.xt.util.jdbc.DataBaseUtil;

import java.sql.Connection;

/**
 * 连接测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 08:50
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        Connection conn1= DataBaseUtil.getConnection();
        System.out.println(conn1.hashCode());
        try{
            conn1.close();
        }catch (Exception ex){
        }
        Connection conn2= DataBaseUtil.getConnection();
        System.out.println(conn2.hashCode());
        try{
            conn2.close();
        }catch (Exception ex){
        }
        Thread th=new Thread(()->{
            Connection conn3= DataBaseUtil.getConnection();
            System.out.println("conn3:"+conn3.hashCode());
            try{
                conn2.close();
            }catch (Exception ex){
            }
        });
        th.start();

    }
}
