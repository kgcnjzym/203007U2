package com.xt.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 08:43
 * @since V1.00
 */
@Controller
@RequestMapping("first")
public class FirstController {
    private Logger logger=Logger.getRootLogger();
    @RequestMapping("test1")
    public String test1(){
        logger.info("this is test1 in FirstController");
        return "first";
    }
    @RequestMapping(value="test1",method = {RequestMethod.POST,RequestMethod.GET})
    public String test2(){
        logger.info("this is test1 in FirstController with GET/POST");
        return "first";
    }
    @RequestMapping(value="test1",method = {RequestMethod.GET},
            params = {"name","age"})
    public String test3(String name,Integer age){
        logger.info("this is test1 in FirstController with GET,name="+name+",age="+age);
        return "first";
    }
    @RequestMapping(value="test1",method = {RequestMethod.GET},
            params = "name=tom")
    public String test5(String name){
        logger.info("this is test1 in FirstController with GET,name="+name);
        return "first";
    }
    @RequestMapping(value="test1",method = {RequestMethod.GET},
            params = {"name","age"},
            headers={"User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"})
    public String test4(String name,Integer age){
        logger.info("this is test1 in FirstController with GET,name="+name+",age="+age);
        return "first";
    }

    @RequestMapping(value="test*",method = {RequestMethod.GET})
    public String test6(){
        logger.info("this is test1 in FirstController with GET");
        return "first";
    }
    @RequestMapping(value="test?",method = {RequestMethod.GET})
    public String test7(){
        logger.info("this is test1 in FirstController with GET");
        return "first";
    }
    @RequestMapping(value="test/*",method = {RequestMethod.GET})
    public String test8(){
        logger.info("this is test1 in FirstController with GET");
        return "first";
    }
    @RequestMapping(value="test/**",method = {RequestMethod.GET})
    public String test9(){
        logger.info("this is test1 in FirstController with GET");
        return "first";
    }
    @RequestMapping(path ={"/test111","/test222"} ,method = {RequestMethod.GET})
    public String test10(){
        logger.info("this is test1 in FirstController with GET");
        return "first";
    }

    //RESTful
    @RequestMapping(path ={"/test1/{name}"} ,method = {RequestMethod.GET})
    public String test11(@PathVariable String name){
        logger.info("this is test1 in FirstController with GET,name="+name);
        return "first";
    }
}
