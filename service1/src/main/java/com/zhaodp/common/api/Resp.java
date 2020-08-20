package com.zhaodp.common.api;

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
public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "状态码", required = true)
    private int code;
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty(value = "返回消息", required = true)
    private String message;

    private Resp(int resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private Resp(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    public static <T> Resp<T> success(String msg) {
        return new Resp(ResultCode.SUCCESS.getCode(), msg);
    }

    public static <T> Resp<T> success(T data) {
        return success(data, "操作成功");
    }

    public static <T> Resp<T> success(T data, String msg) {
        return new Resp(ResultCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> Resp<T> fail(String msg) {
        return new Resp(ResultCode.FAILURE.getCode(), msg);
    }

    public static <T> Resp<T> fail(int code, String msg) {
        return new Resp(code, null, msg);
    }

}