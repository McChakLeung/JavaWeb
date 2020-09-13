package com.dgpalife.model;

public class User {

    private Integer id;

    private String username;

    private String pwd;

    private String email;

    private String telephone;

    private String registDate;

    public User(Integer id, String username, String pwd, String email, String telephone, String registDate) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.email = email;
        this.telephone = telephone;
        this.registDate = registDate;
    }

    public User(String username, String pwd, String email, String telephone) {
        this.username = username;
        this.pwd = pwd;
        this.email = email;
        this.telephone = telephone;
    }

    public User(String username, String pwd, String email, String telephone, String registDate) {
        this.username = username;
        this.pwd = pwd;
        this.email = email;
        this.telephone = telephone;
        this.registDate = registDate;
    }

    public User(Integer id, String username, String email, String telephone, String registDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.registDate = registDate;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }
}
