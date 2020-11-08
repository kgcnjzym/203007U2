package test;

import com.xt.util.jdbc.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/8 08:56
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ResultSetMetaData rsmd=null;
        String sql="select stuid id,name,age,gender from student";
        try{
            conn=DataBaseUtil.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            rsmd=rs.getMetaData();
            for (int i=0;i<rsmd.getColumnCount();i++){
                String colName=rsmd.getColumnName(i+1);
                String colLabel=rsmd.getColumnLabel(i+1);
                System.out.println(colName+"\t"+colLabel);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            DataBaseUtil.closeQuietly(stmt,rs);
        }
    }
}
