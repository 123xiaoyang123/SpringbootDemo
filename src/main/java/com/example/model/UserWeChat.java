package com.example.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("userWeChat")
public class UserWeChat {

    private static final long serialVersionUID = 1L;
    /**
     * open_id
     */
    @TableId(value = "open_id",type = IdType.INPUT)
    private String openId;
    /**
     * skey
     */
    private String skey;
    /**
     * 创建时间
     */
    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 最后登录时间
     */
    @TableField("last_visit_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastVisitTime;
    /**
     * session_key
     */
    @TableField("session_key")
    private String sessionKey;
    /**
     * 市
     */
    @TableField("city")
    private String city;
    /**
     * 省
     */
    @TableField("province")
    private String province;
    /**
     * 国
     */
    @TableField("country")
    private String country;
    /**
     * 头像
     */
    @TableField("avatar_url")
    private String avatarUrl;
    /**
     * 性别
     */
    @TableField("gender")
    private Integer gender;
    /**
     * 网名
     */
    @TableField("nick_name")
    private String nickName;

}
