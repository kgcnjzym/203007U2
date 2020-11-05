package com.xt;

import com.xt.entity.Student;

import java.sql.*;

/**
 * JDBC操作步骤示例：读
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/4 10:13
 * @since V1.00
 */
public class Second {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;//游标
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
            String sql = "select * from student" +
                    " where stuid=7";
            rs=stmt.executeQuery(sql);//BOF
            if(rs.next()){//移动到下一个位置
                Student stu=new Student();
                stu.setId(rs.getInt(1));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt(3));
                stu.setGender(rs.getString(4));
                System.out.println(stu);
            }
            else{
                System.out.println("查无此人");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally{
            //5.释放资源
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
