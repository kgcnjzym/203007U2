package com.xt.pt;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 11:40
 * @since V1.00
 */
@Getter
@Setter
public class Printer {
    private Ink ink;
    private Paper paper;
    private String brand;

    public void print(){
        System.out.println("使用"+ink.color()+"墨盒和"+
                paper.size()+"纸张在"+brand+"打印机上打印");
    }

}
