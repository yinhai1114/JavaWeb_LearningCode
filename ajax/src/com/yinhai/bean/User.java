package com.yinhai.bean;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class User {
    private Integer id;
    private String username;
    private String pwd;
    private String email;
    //反射必须提供无参构造器
    public User(){

    }
    public User(Integer id, String username, String pwd, String email) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
