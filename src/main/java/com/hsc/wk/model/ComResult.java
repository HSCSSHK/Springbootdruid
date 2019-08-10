package com.hsc.wk.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class ComResult<T> {
    /**
     * 不支持的参数值
     */
    public static final int ERROR_CODE_UN_SUPPORT_ARGUMENTS_VALUE = -3;
    public static final int ERROR_CODE_UN_SUPPORT_ACTION = -4;
    public static ComResult SYSTEM_ERR = errorOf(-1, "系统错误","");
    int resCode;
    String resMessage;
    T data;

    public static <O> ComResult<O> sucessOf(O object) {
        ComResult<O> result = new ComResult<O>();
        result.resCode = 0;
        result.resMessage = "成功";
        result.data = object;
        return result;
    }

    public static ComResult errorOf(int errorCode, String message, Object object) {
        ComResult result = new ComResult();
        result.resCode = errorCode;
        result.resMessage = message;
        result.data = object;
        return result;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean successful() {
        return resCode == 0;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
