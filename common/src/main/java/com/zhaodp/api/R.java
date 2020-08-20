package com.zhaodp.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author zhaodp
 * @Date 2020-8-19
 */
@ApiModel(description = "返回信息")
@Data
@ToString
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "状态码", required = true)
    private int code;
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty(value = "返回消息", required = true)
    private String message;

    private R(int resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    public static <T> R<T> success(String msg) {
        return new R(ResultCode.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> success(T data) {
        return success(data, "操作成功");
    }

    public static <T> R<T> success(T data, String msg) {
        return new R(ResultCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> R<T> fail(String msg) {
        return new R(ResultCode.FAILURE.getCode(), msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return new R(code, null, msg);
    }

}