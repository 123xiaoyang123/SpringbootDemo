package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lj
 * @ClassName LoginDto.java
 * @Description TODO 获取前端登录信息
 * @createTime 2022年04月13日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String name;

    private String pwd;
}
