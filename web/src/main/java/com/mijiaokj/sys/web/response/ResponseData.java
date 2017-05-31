package com.mijiaokj.sys.web.response;

import com.alibaba.fastjson.JSON;
import com.mijiaokj.sys.common.util.StringUtil;

import java.io.Serializable;

/**
 * Created by sunchenguang on 2017/5/31.
 */
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = -5351431838232138965L;
    private boolean success;
    private String successMessage;
    private String pageControl;
    private String redirectUrl;
    private T data;
    private Error error = new Error();

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public ResponseData() {
        this.success = true;
    }

    public ResponseData(T data) {
        if(data != null && data.getClass().equals(ErrorType.class)) {
            this.success = false;
            this.error.setCode(((ErrorType)data).getErrorCode());
            this.error.setMessage(((ErrorType)data).getErrorMsg());
        } else {
            this.success = true;
            this.setData(data);
        }

    }

    public ResponseData(ErrorType errorType, String errorMsg) {
        this.success = false;
        String errorCode = errorType.getErrorCode();
        errorMsg = StringUtil.isBlank(errorMsg)?errorType.getErrorMsg():errorMsg;
        this.error.setCode(errorCode);
        this.error.setMessage(errorMsg);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorCode(String errorCode) {
        this.error.setCode(errorCode);
    }

    public void setErrorMsg(String errorMsg) {
        this.error.setMessage(errorMsg);
    }

    public Object getData() {
        return this.data;
    }

    public String getPageControl() {
        return this.pageControl;
    }

    public void setPageControl(String pageControl) {
        this.pageControl = pageControl;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String getSuccessMessage() {
        return this.successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}