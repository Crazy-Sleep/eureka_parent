package com.bosssoft.user.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@TableName("bs_user")
@Data
@Accessors(chain = true)
public class UserDto implements Serializable {

    private Integer id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 性别
     */
    private Integer userSex;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
