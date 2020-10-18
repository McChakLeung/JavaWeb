package com.dgpalife.util;

import java.util.List;

public class PageBean<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalRecord;
    private Integer totalPage;
    private Integer startLine;
    private List<T> dataList;
    private Integer start;
    private Integer end;

    public PageBean(Integer pageNum,Integer pageSize,Integer totalRecord){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //需要计算的成员变量
        if(totalRecord%pageSize == 0){
            this.totalPage = totalRecord/pageSize;
        }else {
            this.totalPage = totalRecord/pageSize + 1;
        }

        this.startLine = (pageNum - 1) * pageSize;

        //计算start和end
        this.start = 1;
        this.end = 5;

        //判断totalPage是否在end的范围内
        if(this.totalPage <= 5){
            this.end = this.totalPage;
        }else{
            this.start = pageNum - 2;
            this.end = pageNum + 2;

            if(this.start <=0 ){
                this.start = 1;
                this.end = this.start + 5;
            }

            if(this.end > this.totalPage){
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
