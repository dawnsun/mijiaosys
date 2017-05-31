package com.mijiaokj.sys.web.response;

/**
 * 页面错误信息封装
 * Created by sunchenguang on 2017/5/31.
 */
public class Error {
    private String code;
    private String message;

    public Error() {
    }

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
