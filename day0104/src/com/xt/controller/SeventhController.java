package com.xt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/7 09:34
 * @since V1.00
 */
@Controller
@RequestMapping("seventh")
public class SeventhController {
    @RequestMapping(path="up",method = RequestMethod.POST)
    public String upload(String desc, MultipartFile file, Model model, HttpServletRequest request){
        model.addAttribute("desc",desc);
        String path=request.getServletContext().getRealPath("imgs");
        File filePath=new File(path);
        if(! filePath.exists()){
            filePath.mkdirs();
        }
        String imgFileName=System.currentTimeMillis()+".jpg";

        try {
            file.transferTo(new File(filePath,imgFileName));
            model.addAttribute("imgPath","imgs/"+imgFileName);
        } catch (Exception e) {
            model.addAttribute("msg",e.getMessage());
        }
        return "upload";
    }


}
