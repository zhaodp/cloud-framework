package com.zhaodp.req;

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
public class AddUserReq {
    @ApiModelProperty(name = "姓名", required = true)
    @NotBlank(message = "姓名不能为空")
    private String name;
    @ApiModelProperty(name = "年龄", required = true)
    @NotNull(message = "年龄不能为空")
    private Integer age;
}
