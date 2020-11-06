package test;

import com.xt.util.jdbc.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日期时间相关类型的获取
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 10:34
 * @since V1.00
 */
public class Test4 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select * from borrow where bid=1 and rid=1";
        SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                Date rt=rs.getTimestamp(5);
                System.out.println(fmt.format(rt));
            }
        }
        catch(Exception ex){

        }
        finally{
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }
}
