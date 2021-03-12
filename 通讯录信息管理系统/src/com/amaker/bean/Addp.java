package com.amaker.bean;

public class Addp {
    private int id;
    private String name;
    private String phoneNum;

    public void setSort(String sort) {
        this.sort = sort;
    }

    private String sex;
    private String QQ;
    private String sort;
    //private String Wechat;

    public String getSort() {
        return sort;
    }

    /* public String getWechat() {
            return Wechat;
        }

        public void setWechat(String wechat) {
            Wechat = wechat;
        }
    */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getSex() {
        return sex;
    }

    public String getQQ() {
        return QQ;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

}
