package test;

import com.xt.util.jdbc.DataBaseUtil;

import java.sql.*;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/8 08:56
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
        Connection conn=null;
        DatabaseMetaData dbmd=null;
        ResultSet rs=null;
        ResultSetMetaData rsmd=null;
        try{
            conn=DataBaseUtil.getConnection();
            dbmd=conn.getMetaData();
            rs=dbmd.getTables("db1","","",new String[]{"view","table"});
            rsmd=rs.getMetaData();
//            rsmd.getColumnLabel()
            while(rs.next()) {
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String colName = rsmd.getColumnName(i + 1);
//                    int type = rsmd.getColumnType(i + 1);
                    String val=rs.getString(colName);
                    System.out.print(colName + ":" + val+"\t");
                }
                System.out.println();
            }
//            rs=dbmd.getPrimaryKeys("db1","","teacher");
//            while(rs.next()){
//                System.out.println(rs.getString(4));
//            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            DataBaseUtil.closeQuietly(null,rs);
        }
    }
}
