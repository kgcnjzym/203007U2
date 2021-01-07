package com.xt.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/5 12:17
 * @since V1.00
 */
@ControllerAdvice
public class MyExceptionAdvice {
    @ExceptionHandler
    public String doException(Exception ex){
        System.out.println(ex);
        return "index";
    }

    @ExceptionHandler({MultipartException.class})
    public String doExceptionHandle(Exception ex){
        System.out.println("产生异常 in MyExceptionAdvice");
        return "redirect:/upload.html";
    }
}
