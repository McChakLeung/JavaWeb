package com.dgpalife.util;

import java.util.List;

public class PageBean<T> {

    //基本的参数
    private Integer pageNum; //前端传入的当前页
    private Integer pageSize; //每页展示的行数
    private Integer totalRecord; //总行数

    //需要计算的参数
    private Integer totalPage; //总页数
    private Integer startLine; //传入的当前页开始的行数

    //存储当前页的数据行
    private List<T> dataList;

    //分页显示的页数,比如在页面上显示1，2，3，4，5页，start就为1，end就为5，这个也是算过来的
    //如果页面没有，就不需要使用
    private Integer start;
    private Integer end;

    //构造方法
    public PageBean(Integer pageNum, Integer pageSize, Integer totalRecord){
        //将变量传入到对象中
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //计算totalPage和startLine
        if(totalRecord%pageSize==0){
            this.totalPage = totalRecord/pageSize;
        }else{
            this.totalPage = totalRecord/pageSize + 1;
        }

        this.startLine = (pageNum -1) * pageSize;

        //判断start和end
        //赋初始值
        this.start = 1;
        this.end = 5;

        //如果totalPage小于或等于5,则end=totalPage
        if(this.totalPage <= 5){
            this.end = this.totalPage;
        }else{
            //start和end已经在totalPage的范围内,刨去首页尾页，上一页和下一页，重新赋值start和end
            this.start = pageNum - 2;
            this.end = pageNum + 2;

            //再次判断start和end，看是否超出范围
            if(this.start <=0){
                this.start = 1;
                //this.end = 5;
            }

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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartLine() {
        return startLine;
    }

    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
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
