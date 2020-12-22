package com.xt.dao;

import com.xt.entity.User;
import com.xt.entity.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-22 10:11:21
 */
@CacheNamespace
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(column = "score",property = "point")
    })
    User queryById(Integer id);

    @Select("select * from users where id=#{id}")
    @Results({
        @Result(column = "id",property = "id",id = true),
        @Result(column = "score",property = "point"),
        @Result(column = "id",property = "orders",
            many = @Many(select = "com.xt.dao.OrderDao.selectByUser"))
    })
    UserVo selectVoById(Integer id);


    /**
     * 根据姓名和/或Email模糊查询
     * @param user
     * @return
     */
    @SelectProvider(type= UserSelectProvider.class,method = "blurQuery")
    List<User> selectByUser(User user);

    /**
     * 根据不同年龄条件查询
     * @param minAge
     * @param maxAge
     * @return
     */
    @Select("<script>select * from users\n" +
            "        <choose>\n" +
            "            <when test=\"minAge neq null and maxAge neq null and minAge lt " +
            "maxAge\">\n" +
            "                where age between #{minAge} and #{maxAge}\n" +
            "            </when>\n" +
            "            <when test=\"minAge neq null and maxAge neq null and minAge gte " +
            "maxAge\">\n" +
            "                where age between #{maxAge} and #{minAge}\n" +
            "            </when>\n" +
            "            <when test=\"minAge neq null and maxAge eq null\">\n" +
            "                where age &gt; #{minAge}\n" +
            "            </when>\n" +
            "            <when test=\"minAge eq null and maxAge neq null\">\n" +
            "                where age &lt; #{maxAge}\n" +
            "            </when>\n" +
            "        </choose></script>")
    List<User> selectByAges(@Param("minAge") Integer minAge,
                             @Param("maxAge") Integer maxAge);

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    @Select("select * from users ")
    List<User> queryAll();

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    @Insert("insert into users values(0,#{name},'123456',#{email},'M',22,#{phone},0,1)")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(User user);



    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}