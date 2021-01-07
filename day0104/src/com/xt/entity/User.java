package com.xt.entity;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xt.valid.UserLoginGroup;
import com.xt.valid.UserRegGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 11:51
 * @since V1.00
 */
@Data
@JSONType(serialzeFeatures = {SerializerFeature.WriteDateUseDateFormat,
SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.DisableCircularReferenceDetect})
public class User {
    private Integer id;
    @NotNull(groups = {UserRegGroup.class, UserLoginGroup.class})
    @Pattern(groups = {UserRegGroup.class, UserLoginGroup.class},
            regexp ="[a-zA-Z0-9]{3,16}")
    private String name;

    @NotNull(groups = {UserRegGroup.class, UserLoginGroup.class})
    @Length(groups = {UserRegGroup.class, UserLoginGroup.class},min = 6,max = 18)
    private String password;

    @Email(groups = {UserRegGroup.class})
    @NotBlank(groups = {UserRegGroup.class})
    private String email;

    @NotNull(groups = {UserRegGroup.class})
    @Range(groups = {UserRegGroup.class},min = 0,max = 160)
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8" )
    @Past(groups = {UserRegGroup.class})
    private Date birth;

    private String headImage;
}
