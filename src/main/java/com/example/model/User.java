package com.example.model;

public class User {
    /*
    * 编号
    * */
    private int uCode;
    /*
    * 姓名
    * */
    private String uName;
    /*
    * 密码
    * */
    private String uPwd;
    /*
    * 身份
    * */
    private int uType;
    /*
    * 备注
    * */
    private String uMemo;

    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    public int getuCode() {
        return uCode;
    }

    public void setuCode(int uCode) {
        this.uCode = uCode;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuMemo() {
        return uMemo;
    }

    public void setuMemo(String uMemo) {
        this.uMemo = uMemo;
    }

    @Override
    public String toString() {
        return "User{" +
                "uCode=" + uCode +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uType=" + uType +
                ", uMemo='" + uMemo + '\'' +
                '}';
    }

    public User(int uCode, String uName, String uPwd, int uType, String uMemo) {
        this.uCode = uCode;
        this.uName = uName;
        this.uPwd = uPwd;
        this.uType = uType;
        this.uMemo = uMemo;
    }

    public User() {
    }
}
