package com.yinhai.furns.javabean;

import java.util.List;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 * 一个分页的数据模型 包含了分页的各种信息
 */
//用一个泛型 分页模型对应的数据类型是不确定的
public class Page<T> {
    //每页显示多少条记录可以在其他地方也用到 建议置为常量
    //ctrl + shift + u 切换大小写
    public static final Integer PAGE_SIZE = 3;

    //表示显示当前页
    private  Integer pageNo;

    //每页显示多少记录
    private  Integer pageSize = PAGE_SIZE;

    //表示共有多少页
    private Integer pageTotalCount;

    //表示的是共有多少条记录 通过totalRow和pageSize计算得到pageTotalCount
    //这个可以交给DAO完成
    private Integer totalRow;

    //表示当前页要显示的数据
    //这个也可以交给DAO完成
    private List<T> items;

    //分页导航的字符串
    private String url;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
