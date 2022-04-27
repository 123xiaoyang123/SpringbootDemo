package com.example.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("userJwt")
public class UserJwtTest implements Serializable {

    @TableId(value = "id", type = IdType.INPUT)
    private int id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "pwd")
    private String pwd;
    @TableField(value = "role")
    private String role;

    private static final long serialVersionUID = 1L;

}
