package test;

import com.xt.util.jdbc.DataBaseUtil;

import java.sql.Connection;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/8 12:07
 * @since V1.00
 */
public class Test5 {
    public static void main(String[] args) {
        DataBaseUtil.DBPOOL_TYPE="druid";
        Connection conn= DataBaseUtil.getConnection();
        System.out.println(conn.getClass());
        DataBaseUtil.closeConnection();
    }
}
