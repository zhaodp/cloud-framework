package com.zhaodp.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author zhaodp
 * @Date 2020-8-21
 */
@Data
@ApiModel
public class UserIdReq {
    @ApiModelProperty(name = "用户id", required = true)
    @NotBlank(message = "id参数不能为空")
    private Long id;
}
