package com.xt.converter;

import com.xt.entity.Seat;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/5 09:33
 * @since V1.00
 */
@Component
public class SeatConverter implements Converter<String, Seat> {
    private Logger logger=Logger.getRootLogger();
    @Override
    public Seat convert(String s) {
        logger.info("原始数据："+s);
        //1-3
        Seat st=new Seat();
        try{
            String []arr=s.split("-");
            st.setRow(Integer.parseInt(arr[0]));
            st.setSeats(Integer.parseInt(arr[1]));
            if(st.getRow()<1 || st.getSeats()<1){
                throw new RuntimeException("座位信息不合法");
            }
        }
        catch (Exception ex){
            logger.warn(ex.getMessage());

        }
        logger.info("转换之后："+st);
        return st;
    }
}
