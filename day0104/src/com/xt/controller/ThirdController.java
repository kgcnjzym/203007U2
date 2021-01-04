package com.xt.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 08:43
 * @since V1.00
 */
@Controller
@RequestMapping("third")
public class ThirdController {
    private Logger logger=Logger.getRootLogger();
    @RequestMapping("test1")
    public String test1(@CookieValue(value="name",required = false) String name,
                        @CookieValue(value="pass",required = false) String pass){
        logger.info("this is test1 in ThirdController,name="+name+",pass="+pass);
        return "first";
    }

    @RequestMapping("test2")
    public String test2(@RequestHeader("user-agent") String agent){
        logger.info("this is test1 in ThirdController,user-agent="+agent);
        return "first";
    }

    @RequestMapping("test3")
    public String test3(@Value("${log4j.rootLogger}") String value,
                        @Value("#{propa.name}") String name,
                        @Value("#{propa['user.pass']}") String pass){
        logger.info("this is test1 in ThirdController,name="+name+",pass="+pass+",value="+value);
        return "first";
    }


}
