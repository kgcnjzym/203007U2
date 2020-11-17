package com.xt.entity;

/**
 * 分页辅助类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/17 12:07
 * @since V1.00
 */
public class Paginate {
    private static final Integer MIN_PAGESIZE=3;
    private Integer pageNo;
    private Integer pageSize;
    private Integer pages;
    private Integer records;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo<1){
            this.pageNo=1;
        }
        else {
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize<MIN_PAGESIZE){
            this.pageSize=MIN_PAGESIZE;
        }
        else {
            this.pageSize = pageSize;
        }
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        if(records==0){
            throw new RuntimeException("查无数据");
        }
        this.records = records;
        this.pages=(records+this.pageSize-1)/this.pageSize;
        this.pageNo=this.pageNo>pages?pages:this.pageNo;
    }
}
