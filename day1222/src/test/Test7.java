package test;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test7 {

    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {

        while (true){
            System.out.println("==pls choice==");
            System.out.println("1.查询用户");
            System.out.println("2.修改用户");
            System.out.println("其它：退出");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    query();
                    break;
                case 2:
                    update();
                    break;
            }
            if(choice!=1 && choice!=2){
                break;
            }
        }
        scanner.close();
    }

    private static void update() {
        try(SqlSession session= SqlSessionUtil.getSqlSession(true)){
            UserDao dao=session.getMapper(UserDao.class);
            User temp=new User();
            System.out.println("pls input user id:");
            int id=scanner.nextInt();
            temp.setId(id);
            System.out.println("pls input new name:");
            String name=scanner.next();
            temp.setName(name);
            int ret=dao.update(temp);
            if(ret>0){
                System.out.println("ok");
            }
            else{
                System.out.println("fail");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void query() {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            UserDao dao=session.getMapper(UserDao.class);
            System.out.println("pls input user id:");
            int id=scanner.nextInt();
            User temp=dao.queryById(id);
            if(temp==null){
                System.out.println("not found");
            }
            else{
                System.out.println(temp);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
