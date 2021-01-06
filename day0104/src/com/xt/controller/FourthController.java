package com.xt.controller;

import com.xt.entity.Seat;
import com.xt.entity.User;
import com.xt.valid.UserLoginGroup;
import com.xt.valid.UserRegGroup;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 08:43
 * @since V1.00
 */
@Controller
@RequestMapping("fourth")
public class FourthController {
    private Logger logger=Logger.getRootLogger();
    @RequestMapping("test1")
    public String test1(User user){
        logger.info("user:"+user);
        return "first";
    }

    @RequestMapping("test2")
    public String test2(Seat seat){
        logger.info("seat:" + seat);
        return "first";
    }

    @RequestMapping("login")
    public String login(@Validated({UserLoginGroup.class}) User user, Errors errors, String code){
        if(errors.hasErrors()){
            return "login";
        }
        if(code==null || code.length()!=4){
            errors.rejectValue("age","validcode","验证码错误！");
            return "login";
        }
        return "first";
    }

    @RequestMapping("reg")
    public String reg(@Validated({UserRegGroup.class}) User user, Errors errors){
        System.out.println(errors.getFieldError("name").getDefaultMessage());
        if(errors.hasErrors()){
            return "reg";
        }
        return "first";
    }

    @RequestMapping("page")
    public String page(Integer pno) throws Exception{
        System.out.println("pno=" + pno);
        if(pno>100){
            throw new Exception("overflow");
        }
        return "first";
    }

    @ExceptionHandler({RuntimeException.class})
    public String doException(Exception ex){
        System.out.println(ex);
        return "first";
    }

}
