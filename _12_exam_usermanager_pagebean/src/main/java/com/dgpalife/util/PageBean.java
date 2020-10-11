package com.dgpalife.util;

import java.util.List;

public class PageBean<T> {
    //不需要计算的参数
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalRecord;

    //需要计算的参数
    private Integer startLine;
    private Integer totalPage;

    //存储分页的数据
    private List<T> dataList;

    //定义start和end
    private Integer start;
    private Integer end;

    //定义构造函数
    public PageBean(Integer pageNum, Integer pageSize, Integer totalRecord){
        //初始化成员变量
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //初始行需要计算的成员变量
        //计算totalPage
        if(totalRecord % pageSize == 0){
            this.totalPage = totalRecord / pageSize;
        }else{
            this.totalPage = totalRecord / pageSize + 1;
        }

        //计算startLine
        this.startLine = (pageNum -1) * pageSize;

        //判断start和end
        this.start = 1;
        this.end = 5;

        //判断totalPage是否超出了end的范围，
        //如果在范围内，则直接end = totalpage,
        //如果不在范围内，再进入下一层判断
        if(this.totalPage <= 5){
            this.end = this.totalPage;
        }else{
            //totalPage不在end的范围内，需要重新调整start和end的初始值
            this.start = pageNum - 2;
            this.end = pageNum + 2;

            //如果调整后的start小于0，说明调整后的start不符合逻辑，需要设定为1
            if(this.start <=0){
                this.start = 1;
                this.end = this.start + 5;
            }

            //如果调整后的end大于totalPage,说明调整后的end不符合逻辑，需设定为totalPage
            if(this.end >= this.totalPage){
                this.end = this.totalPage;
                this.start = this.end - 5;
            }
        }
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getStartLine() {
        return startLine;
    }

    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
