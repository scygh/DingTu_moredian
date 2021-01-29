package com.moredian.entrance.guard.entity;

import java.io.Serializable;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/8 09:36
 */
public class BaseResponseAddisOK<T> implements Serializable {

    private T Content;
    private boolean Result;
    private String Message;
    private int StatusCode;
    private boolean IsOk;

    public T getContent() {
        return Content;
    }

    public void setContent(T content) {
        Content = content;
    }

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean result) {
        Result = result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public boolean isOk() {
        return IsOk;
    }

    public void setOk(boolean ok) {
        IsOk = ok;
    }
}
