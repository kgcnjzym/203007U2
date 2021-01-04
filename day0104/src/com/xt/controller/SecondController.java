package com.xt.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 08:43
 * @since V1.00
 */
@Controller
@RequestMapping("second")
public class SecondController {
    private Logger logger=Logger.getRootLogger();
    @RequestMapping("test1")
    public String test1(@RequestParam(value="firstname",
            required = false,defaultValue = "admin") String name){
        logger.info("this is test1 in SecondController,name="+name);
        return "first";
    }

    @RequestMapping("test2")
    public String test2(HttpSession session){
        session.setAttribute("name","mike");
        logger.info("this is test2 in SecondController");
        return "first";
    }

    @RequestMapping("test4")
    public String test4(Map<String , Object> map){
        logger.info("this is test4 in SecondController");
        map.put("user","tom");
        map.put("age",20);
        return "first";
    }

    @RequestMapping("test5")
    public String test5(WebRequest req){
        logger.info("this is test4 in SecondController");
        req.setAttribute("name","mike",WebRequest.SCOPE_SESSION);
        req.setAttribute("age",20,WebRequest.SCOPE_REQUEST);
        return "first";
    }

    @RequestMapping("validcode")
    public void test3(HttpSession session,OutputStream os){
        int length=4;
        logger.info("this is validcode in SecondController");
        Random rnd=new Random();
        String code="";
        for (int i = 0; i < length; i++)
        {
            //0-9：数字；10-35：大写字母；36-61：小写字母
            int n=rnd.nextInt(62);
            if(n<10) {
                code += n;
            }
            else if(n<36) {
                code += (char) (n - 10 + 'A');
            }
            else {
                code += (char) (n - 36 + 'a');
            }
        }

        session.setAttribute("code", code);

        //创建图片对象（缓存在内存中）
        BufferedImage image = new BufferedImage(
                100, 25, BufferedImage.TYPE_INT_RGB);
        //获取图片的画笔对象
        Graphics gra = image.getGraphics();
        //设置颜色
        gra.setColor(Color.yellow);
        //绘制边框，实际是绘制一个矩形
        gra.fillRect(2, 2, 96, 21);
        // 设置字体
        gra.setFont(new Font("Times New Roman", Font.BOLD, 20));
        for (int i = 0; i < length; i++)
        {
            //产生随机颜色
            Color clr=new Color(rnd.nextInt(256),
                    rnd.nextInt(256),rnd.nextInt(256));
            //设置字体颜色
            gra.setColor(clr);
            //绘制文字
            gra.drawString(code.substring(i,i+1),10+96/length*i,18);
        }
        //绘制干扰线
        for (int i = 0; i < length+1; i++)
        {
            Color clr=new Color(rnd.nextInt(256),
                    rnd.nextInt(256),rnd.nextInt(256));
            //设置线条颜色
            gra.setColor(clr);
            //设置线条粗细
            Graphics2D g2d=(Graphics2D)gra;
            g2d.setStroke(new BasicStroke(1+rnd.nextFloat()+rnd.nextInt(2)));
            gra.drawLine(rnd.nextInt(100), rnd.nextInt(25),
                    rnd.nextInt(100), rnd.nextInt(25));
        }
        try {
            //将缓存中的图片输出到响应流中
            ImageIO.write(image, "jpeg", os);
            os.close();
        }catch (Exception ex){}
    }

    @RequestMapping("test6")
    public String test6(ModelMap mm, NativeWebRequest nreq){
        logger.info("this is test4 in SecondController");
//        mm.addAttribute("","");
//        nreq.getNativeRequest()
//        nreq.setAttribute("","",1);
        return "first";
    }


}
