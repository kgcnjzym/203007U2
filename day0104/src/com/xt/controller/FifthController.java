package com.xt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/6 08:44
 * @since V1.00
 */
@Controller
@RequestMapping("fifth")
public class FifthController {
    @RequestMapping(path="test1/{name}",method = RequestMethod.GET)
    public String test1(@PathVariable String name){
        System.out.println("GET:name="+name);
        return "first";
    }
    @RequestMapping(path="test1/{name}",method = RequestMethod.POST)
    @ResponseBody
    public String test2(@PathVariable String name){
        System.out.println("POST:name="+name);
        return "first";
    }

    @RequestMapping(path="test1/{name}",method = RequestMethod.PUT)
//    @ResponseBody
    public String test3(@PathVariable String name){
        System.out.println("PUT:name="+name);
//        return "{\"name\":\""+name+"\"}";
        return "first";
    }

    @RequestMapping(path="test1/{name}",method = RequestMethod.DELETE)
    @ResponseBody
    public String test4(@PathVariable String name){
        System.out.println("DELETE:name="+name);
        return "{\"name\":\""+name+"\"}";
    }

    @RequestMapping(path="test2/{id}/{name}",method = RequestMethod.POST)
    @ResponseBody
    public String test5(@PathVariable String name,
                        @PathVariable Integer id){
        System.out.println("POST:id="+id+",name="+name);
        return "{\"name\":\""+name+"\",\"id\":"+id+"}";
    }
}
