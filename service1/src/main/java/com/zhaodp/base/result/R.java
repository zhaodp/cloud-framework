package com.zhaodp.base.result;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class R<T> {
    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍候再试";
    public static final String HYSTRIX_ERROR_MESSAGE = "请求超时，请稍候再试";
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = -1;
    public static final int TIMEOUT_CODE = -2;
    /**
     * 统一参数验证异常
     */
    public static final int VALID_EX_CODE = -9;
    public static final int OPERATION_EX_CODE = -10;
    /**
     * 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode]
     */
    @ApiModelProperty(value = "响应编码:0-处理成功 其他-处理失败")
    private int code;

    /**
     * 调用结果
     */
    @ApiModelProperty(value = "响应数据")
    private T data;

    /**
     * 结果消息，如果调用成功，消息通常为空T
     */
    @ApiModelProperty(value = "提示消息")
    private String message = "操作成功";

    private R() {
    }

    public R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    /**
     * 请求成功
     *
     * @param <E>
     * @return
     */
    public static <E> R<E> success() {
        return new R<>(SUCCESS_CODE, null, "操作成功");
    }

    /**
     * 请求成功消息
     *
     * @param data 结果
     * @return RPC调用结果
     */
    public static <E> R<E> success(E data) {
        return new R<>(SUCCESS_CODE, data, "操作成功");
    }

    /**
     * 请求成功方法 ，data返回值，msg提示信息
     *
     * @param data 结果
     * @param msg  消息
     * @return RPC调用结果
     */
    public static <E> R<E> success(E data, String msg) {
        return new R<>(SUCCESS_CODE, data, msg);
    }

    /**
     * 请求失败消息
     *
     * @param msg
     * @return
     */
    public static <E> R<E> error(int code, String msg) {
        return new R<>(code, null, (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg);
    }

    public static <E> R<E> error() {
        return error(OPERATION_EX_CODE, DEF_ERROR_MESSAGE);
    }

    public static <E> R<E> error(IResultCode resultCode) {
        return error(resultCode.getCode(), resultCode.getMessage());
    }

    public static <E> R<E> error(String msg) {
        return error(OPERATION_EX_CODE, msg);
    }

    public static <E> R<E> error(String msg, Object... args) {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new R<>(OPERATION_EX_CODE, null, String.format(message, args));
    }

    public static <E> R<E> result(boolean flag) {
        return flag ? success() : error();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}