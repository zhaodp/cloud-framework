package com.zhaodp.base.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class PageDTO<T> {

    @ApiModelProperty(value = "记录总数")
    private long totalSize;

    @ApiModelProperty(value = "当前页数")
    private long pageNo;

    @ApiModelProperty(value = "每页记录数")
    private long pageSize;

    @ApiModelProperty(value = "总页数")
    private long pages;

    @ApiModelProperty(value = "列表")
    private List<T> list;

}
