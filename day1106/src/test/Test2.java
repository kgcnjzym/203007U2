package test;

import com.xt.util.jdbc.DataAccessException;
import com.xt.util.jdbc.JdbcTemplate;
import com.xt.util.jdbc.TransactionManager;

/**
 * 事务测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 08:52
 * @since V1.00
 */
public class Test2 {
    public static void main(String[] args) {
        String sqlInsert="insert into borrow values(?,?,now(),null,null)";
        String sqlUpdate="update book set bcount=bcount-? where bid=? and bcount>=?";
        JdbcTemplate template=new JdbcTemplate();
        TransactionManager tm=new TransactionManager();
        try {
            tm.start();
            int rt = template.update(sqlInsert, 2, 12);
            System.out.println("借书：" + rt);
            rt = template.update(sqlUpdate, 1,12,1);
            System.out.println("修改库存：" + rt);
            if(rt==0){
                throw  new DataAccessException("书籍库存不足");
            }
            tm.commit();
        }
        catch (Exception ex){
            System.out.println(ex);
            tm.rollback();
        }

    }
}
