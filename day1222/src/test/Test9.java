package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xt.entity.vo.OrderVo;
import com.xt.service.OrderService;
import com.xt.service.impl.OrderServiceImpl;

import java.util.List;

/**
 * 循环引用测试
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:15
 * @since V1.00
 */
public class Test9 {

    public static void main(String[] args) {
        OrderService service=new OrderServiceImpl();
        List<OrderVo> orders=service.getAll();
//        for(OrderVo vo:orders){
//            System.out.println(vo.getOid()+":"+vo.getUser());
//        }
//        System.out.println("==================");
        System.out.println(JSON.toJSONString(orders,
                SerializerFeature.DisableCircularReferenceDetect));
//        System.out.println(JSON.toJSONString(orders));
        for(OrderVo vo:orders){
            System.out.println(vo.getOid()+":"+vo.getUser().hashCode());
        }
    }
}
