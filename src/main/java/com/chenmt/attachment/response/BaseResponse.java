package com.chenmt.attachment.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.beans.Transient;
import java.util.Objects;

/**
 * @program attachment
 * @description: 返回类
 * @author: chenmet
 * @create: 2020/04/09 11:07
 */
@Data
public class BaseResponse<T> {

    public static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    public static final String DEFAULT_ERROR_MESSAGE = "操作失败";
    public static final String DEFAULT_SUCCESS_CODE = "1";
    public static final String DEFAULT_ERROR_CODE = "0";
    private String code;
    private String msg;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(String code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> BaseResponse<T> success(T t) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("1");
        res.setMsg(DEFAULT_SUCCESS_MESSAGE);
        res.setData(t);
        return res;
    }

    public static <T> BaseResponse<T> success(T data,String msg) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode(DEFAULT_SUCCESS_CODE);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public static <T> BaseResponse<T> success() {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("1");
        res.setMsg(DEFAULT_SUCCESS_MESSAGE);
        res.setData(null);
        return res;
    }

    public static <T> BaseResponse<T> success(String msg) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("1"+"");
        res.setMsg(msg);
        res.setData(null);
        return res;
    }


    public static <T> BaseResponse<T> error(String msg) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("0");
        res.setMsg(msg);
        res.setData(null);
        return res;
    }

    public static <T> BaseResponse<T> error() {
        BaseResponse<T> res = new BaseResponse();
        res.setCode(DEFAULT_ERROR_CODE);
        res.setMsg(DEFAULT_ERROR_MESSAGE);
        res.setData(null);
        return res;
    }

    @Transient
    @JsonIgnore
    public boolean isSuccess() {
        return Objects.equals(this.code, DEFAULT_SUCCESS_CODE);
    }

}
