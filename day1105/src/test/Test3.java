package test;

import com.xt.util.jdbc.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * jdbc-template读操作测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 09:44
 * @since V1.00
 */
public class Test3 {
    public static void main(String[] args) {
        String sql="select * from student where stuid=1";
        ResultSet rs=null;
        Connection conn=null;
        try {
            conn=DataBaseUtil.getConnection();
            rs = DataBaseUtil.query(conn,sql);
            if (rs.next()) {
                System.out.println("name=" + rs.getString("name"));
            } else {
                System.out.println("查无此人");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally{
            DataBaseUtil.closeQuietly(conn,null,rs);
        }
    }
}
