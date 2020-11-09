package test;

import com.xt.util.jdbc.JdbcTemplate;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/9 09:04
 * @since V1.00
 */
public class Test1 {
    public static void main(String[] args) {
//        String sql="insert into reader values(9,'mike',0,'nanjing')";
        String sql="insert into student values(0,?,?,?)";
        JdbcTemplate template=new JdbcTemplate();
        int ret=template.update(sql,true,"marry1",21,"F");
        System.out.println(ret);
    }
}
