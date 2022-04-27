package com.example.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Data
public class Customer {
    /*
     * 客户id
     * */
    private int id;
    /*
     * 客户姓名
     * */
    private String name;
    /*
     * 客户性别
     * */
    private int sex;
    /*
     * 客户出生年月
     * */
    private Date time;
    /*
    * 用户集合
    * */
    private List<User> userList;
}
