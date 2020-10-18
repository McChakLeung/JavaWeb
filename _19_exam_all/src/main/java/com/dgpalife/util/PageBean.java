package com.dgpalife.util;

import java.util.List;

public class PageBean<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Integer totalRecord;

    private Integer startLine;

    private Integer totalPage;

    private List<T> dataList;

    private Integer start;

    private Integer end;

    /**
     * 创建构造方法，该方法能自动计算pagebean类对应的属性
     * @param pageNum
     * @param pageSize
     * @param totalRecord
     */
    public PageBean(Integer pageNum, Integer pageSize, Integer totalRecord){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //计算totalPage
        if(totalRecord%pageSize == 0){
            this.totalPage = totalRecord / pageSize;
        }else{
            this.totalPage = totalRecord / pageSize + 1;
        }

        //计算startLine
        this.startLine = (pageNum -1 ) * pageSize;

        //判断start和end
        this.start = 1;
        this.end = 5;

        //判断totalPage是否在start和end的范围内
        if(this.totalPage <= 5){
            this.end = this.totalPage;
        }else{
            this.start = pageNum - 2;
            this.end = pageNum + 2;

            //如果计算后的start小于或等于0，说明超出了边界
            if(this.start <= 0){
                this.start = 1;
                this.end = this.start + 5;
            }

            //如果计算后的end大于总页数，说明超出了边界
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
