package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 免配置文件
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 09:15
 * @since V1.00
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        TransactionFactory factory=new JdbcTransactionFactory();
        Properties properties=new Properties();
        properties.load(Resources.getResourceAsStream("db.properties"));

        DataSource source=new PooledDataSource(
                properties.getProperty("driverClassName"),
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
        Environment environment=new Environment("jdbc",factory,source);

        Configuration configuration=new Configuration(environment);
        configuration.addMapper(UserDao.class);

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory=builder.build(configuration);
        SqlSession session=sessionFactory.openSession();
        UserDao dao=session.getMapper(UserDao.class);
        User user=dao.selectById(1);
        System.out.println(user);
        session.close();
    }
}
