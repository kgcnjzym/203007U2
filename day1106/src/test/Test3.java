package test;

import com.xt.entity.User;
import com.xt.mapper.UserMapper;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * RowMapper测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 10:09
 * @since V1.00
 */
public class Test3 {
    public static void main(String[] args) {
        UserMapper mapper=new UserMapper();
        JdbcTemplate template=new JdbcTemplate();
//        String sql="select id,name,phone from users where id=?";
//        User user=template.queryOne(sql,mapper,1);
//        System.out.println(user);
        String sql="select * from users where gender=?";
        List<User> us=template.queryList(sql,mapper,"M");
        System.out.println(us);
    }
}
