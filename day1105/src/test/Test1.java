package test;

import com.xt.util.jdbc.DataBaseUtil;

import java.sql.Connection;

/**
 * jdbc-template连接测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 09:09
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        Connection conn=null;
        try{
            conn= DataBaseUtil.getConnection();
            System.out.println(conn);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            DataBaseUtil.closeQuietly(conn,null,null);
        }
    }
}
