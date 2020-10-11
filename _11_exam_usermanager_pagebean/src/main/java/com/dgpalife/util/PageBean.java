package com.dgpalife.util;

import java.util.List;

public class PageBean<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Integer totalLine;

    private Integer totalPage;

    private Integer startLine;

    private List<T> dataList;

    private Integer start;

    private Integer end;

    /**
     * 构造方法，将pagebean初始化
     * @param pageNum 每次从前端传入的当前页数
     * @param pageSize 每页显示的数据行
     * @param totalLine 查询的总行数
     */
    public PageBean(Integer pageNum,Integer pageSize,Integer totalLine){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalLine = totalLine;

        //通过totalLine和pageSize,计算总页数
        if(totalLine%pageSize == 0){
            this.totalPage = totalLine/pageSize;
        }else{
            this.totalPage = totalLine/pageSize + 1;
        }

        //通过pageNum和pageSize计算出startLine
        this.startLine = (pageNum - 1) * pageSize;

        //对start和end赋初始值
        this.start = 1;
        this.end = 5;

        //判断start和end
        //如果end小于totalPage,则end=totalpage,否则进行其他判断
        if(this.totalPage <= 5){
            this.end = this.totalPage;
        }else{
            //总页数大于5，那么就要根据当前是第几页，来判断start和end为多少了
            //对start和end做加减2，是为了显示除去首页/上一页，以及下一页/尾页
            this.start = pageNum - 2;
            this.end = pageNum + 2;

            //如果start<=0,则说明需要重新设定start和end
            if(this.start<=0){
                this.start = 1;
                this.end = 5;
            }

            //如果end>=totalPage,则将totalpage赋值给end, start也需要end-5
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

    public Integer getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(Integer totalLine) {
        this.totalLine = totalLine;
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
