package com.hsc.wk.model;

import lombok.Data;

@Data
public class PageResult<T> extends ComResult<T> {
    long pageTotal;
    int pageSize;
    int pageNumber;

    public static <O> PageResult<O> sucessOf(O object) {
        PageResult<O> result = new PageResult<O>();
        result.resCode = 0;
        result.resMessage = "成功";
        result.data = object;
        return result;
    }

    public static ComResult PageResult(int errorCode, String message) {
        PageResult result = new PageResult();
        result.resCode = errorCode;
        result.resMessage = message;
        return result;
    }
}
