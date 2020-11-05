package com.xt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC操作步骤示例：写
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/4 10:13
 * @since V1.00
 */
public class First {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost/db1",
                    "root","123456");
            //3.创建命令Statement
            stmt=conn.createStatement();
            //4.执行SQL语句，得到并处理结果
            String sql = "insert into student" +
                    " values(0,'张三',18,'M')";
            int ret=stmt.executeUpdate(sql);
            System.out.println("ret="+ret);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally{
            //5.释放资源
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
