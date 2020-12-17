package com.xt.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * 自定义druid数据源工厂
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/17 10:20
 * @since V1.00
 */
public class MyDruidDataSourceFactory
        extends UnpooledDataSourceFactory {
    public MyDruidDataSourceFactory() {
        this.dataSource=new DruidDataSource();
    }
}
