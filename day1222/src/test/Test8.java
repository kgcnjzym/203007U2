package test;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xt.entity.User;
import com.xt.service.UserService;
import com.xt.service.impl.UserServiceImpl;

import java.util.List;

/**
 * 分页插件测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test8 {

    public static void main(String[] args) {
        UserService service=new UserServiceImpl();
        List<User> users=service.getByPage(90,4);
        System.out.println(users.size());
        System.out.println(users.getClass());
        System.out.println(users);
        for(User u:users){
            System.out.println(u);
        }
        System.out.println("========");
        PageInfo<User> info=new PageInfo<>(users,8);
        System.out.println(JSON.toJSONString(info));
//        {"endRow":167,
//        "firstPage":35,
//        "hasNextPage":false,
//        "hasPreviousPage":true,
//        "isFirstPage":false,
//        "isLastPage":true,
//        "lastPage":42,
//        "list":[{"id":166,"name":"user1216-2"},{"id":167,"name":"user1222"},{"id":168,"name":"user1223-1"}],
//        "navigateFirstPage":35,
//        "navigateLastPage":42,
//        "navigatePages":8,
//        "navigatepageNums":[35,36,37,38,39,40,41,42],
//        "nextPage":0,
//        "pageNum":42,
//        "pageSize":4,
//        "pages":42,
//        "prePage":41,
//        "size":3,
//        "startRow":165,
//        "total":167}
    }
}
