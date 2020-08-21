package com.zhaodp.dto.user;

import lombok.Data;

import java.util.Date;

/**
 * @Author zhaodp
 * @Date 2020-8-20
 */
@Data
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
