package com.zhaodp.base.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class PageReq {

    @ApiModelProperty(value = "当前页数")
    private int pageNo = 1;

    @ApiModelProperty(value = "每页记录数")
    private int pageSize = 10;

}
