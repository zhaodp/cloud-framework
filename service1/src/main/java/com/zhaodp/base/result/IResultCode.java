package com.zhaodp.base.result;

public interface IResultCode {
    /**
     * 异常编码
     *
     * @return
     */
    int getCode();

    /**
     * 异常消息
     * @return
     */
    String getMsg();
}
