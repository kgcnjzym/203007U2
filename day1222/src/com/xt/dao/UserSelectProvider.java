package com.xt.dao;

import com.xt.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 11:34
 * @since V1.00
 */
public class UserSelectProvider {
    public String blurQuery(User user){
        return new SQL(){
            {
                SELECT("*");
                FROM("users");
                if(user.getName()!=null){
                    WHERE("name like concat('%',#{name},'%')");
                }
                if(user.getEmail()!=null){
                    AND().WHERE("email like concat('%',#{email},'%')");
                }
            }
        }.toString();
    }
}
