package com.yinhai.furns.javabean;

import java.math.BigDecimal;

/**
 * Furn和mysql表进行映射
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class Furn {
    // private int id;//不能用iNt 要用Integer
    private Integer id;
    private String name;
    private String maker;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    //表的字段是imgPath 而bean用的imgPath 如何解决
    private String imgPath = "assets/images/product-image/default.jpg";

    public Furn(Integer id, String name, String maker, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if(!(null == imgPath || "".equals(imgPath))){
            this.imgPath = imgPath;
        }
    }

    public Furn() {
    }

    @Override
    public String toString() {
        return "Furn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
