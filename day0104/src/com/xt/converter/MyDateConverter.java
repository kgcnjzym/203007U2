package com.xt.converter;


import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/5 09:03
 * @since V1.00
 */
@Component
public class MyDateConverter implements Converter<String, Date> {
    private final String format="yyyy-MM-dd";
    private Logger logger=Logger.getRootLogger();
    @Override
    public Date convert(String s) {
        logger.info("原始数据："+s);
        SimpleDateFormat fmt=new SimpleDateFormat(format);
        try {
            return fmt.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }
}
