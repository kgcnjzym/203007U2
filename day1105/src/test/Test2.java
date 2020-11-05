package test;

import com.xt.util.jdbc.DataBaseUtil;

/**
 * jdbc-template写操作测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 09:44
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        String sql="insert into student" +
                " values(0,'张三',18,'M')";
        int ret= DataBaseUtil.update(sql);
        System.out.println("ret="+ret);
    }
}
