package test;

import com.xt.dao.BookDao;
import com.xt.entity.vo.BookVo;
import com.xt.entity.vo.UserVo;
import com.xt.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 关联映射综合测试2
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 08:57
 * @since V1.00
 */
public class Test4 {
    public static void main(String[] args) {
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            BookDao dao=session.getMapper(BookDao.class);
            List<BookVo> vos=dao.selectSellInfo();
            if(vos.size()==0){
                System.out.println("暂无图书销售记录");
            }
            else{
                for (BookVo vo : vos){
                    System.out.println(vo.getId()+"."+vo.getTitle());
                    List<UserVo> uvos=vo.getUsers();
                    if(uvos.size()==0){
                        System.out.println("\t"+"暂未销售");
                    }
                    else{
                        for(UserVo uvo:uvos){
                            System.out.println("\t"+uvo.getId()+"."
                            +uvo.getName()+":"+uvo.getSummary());
                        }
                    }
                }
            }


        }
    }
}
