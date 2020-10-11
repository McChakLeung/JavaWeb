package com.dgpalife.util;

import java.util.List;

/**
 * 分页类，用于后期分页调用，<T>不指定任何类型
 * @param <T>
 */
public class PageBean<T> {
    //已知数据
    private Integer pageNum; //当前页，从请求传入
    private Integer pageSize;//每页展示的行数，自定义
    private Integer totalRecord;//总的记录数，从数据库中查询出来

    //需要计算得来
    private Integer totalPage;//分页的总页数，通过totalRecord和pageSize计算可以得来

    //开始索引，也就是我们在数据库中要从第几行数据开始拿，有了startIndex和pageSize，
    //就知道了limit语句的两个数据，就能获得每页需要显示的数据了
    private Integer startLine;//

    //将每页要显示的数据放在集合中
    private List<T> dataList;

    //分页显示的页数,比如在页面上显示1，2，3，4，5页，start就为1，end就为5，这个也是算过来的
    //如果页面没有，就不需要使用
    private Integer start;
    private Integer end;

    /**
     * 通过pageNum，pageSize，totalRecord计算得来tatalPage和startIndex
     * 构造方法中将pageNum，pageSize，totalRecord获得
     * @param pageNum
     * @param pageSize
     * @param totalRecord
     */
    public PageBean(Integer pageNum, Integer pageSize, Integer totalRecord){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //计算startLine
        this.startLine = (pageNum - 1)*pageSize;

        //计算totalPage
        if(totalRecord%pageSize == 0){
            //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
            this.totalPage = totalRecord / pageSize;
        }else{
            //不整除，就要在加一页，来显示多余的数据。
            this.totalPage = totalRecord / pageSize + 1;
        }

        //显示5页，这里自己可以设置，想显示几页就自己通过下面算法修改
        this.start = 1;
        this.end = 5;

        //显示页数的算法
        if(totalPage <= 5){
            //总页数都小于5，那么end就为总页数的值了。
            this.end = this.totalPage;
        }else{
            //总页数大于5，那么就要根据当前是第几页，来判断start和end为多少了，
            this.start = pageNum - 2;
            this.end = pageNum + 2;

            if(start<=0){
                this.start = 1;
                this.end = 5;
            }

            if(end > this.totalPage){
                this.end = totalPage;
                this.start = end-5;
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
