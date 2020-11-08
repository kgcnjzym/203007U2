package test;

import com.xt.util.jdbc.DataBaseUtil;
import com.xt.util.jdbc.JdbcTemplate;

/**
 * 标量scale查询示例
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/8 11:15
 * @since V1.00
 */
public class Test4 {
    public static void main(String[] args) {
        DataBaseUtil.PROPERTIES_FILE_NAME="sss.prop";
        JdbcTemplate template=new JdbcTemplate();
        //标量scale：一条记录一个列
        String sql="select id from users where phone=?";
        Integer cnt= template.queryScale(sql,Integer.class,"13412345678");
        System.out.println(cnt);
    }
}
