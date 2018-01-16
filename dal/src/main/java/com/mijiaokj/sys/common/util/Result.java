package com.mijiaokj.sys.common.util;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 
 * @ClassName: Result
 * @Description: TODO 返回结果工具类 
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -6621940073431236104L;
    private boolean success;
    private int total;
    private T data;
    private String successInfo;
    private String successCode;
    private int errorType;
    private String errorCode;
    private String errorMsg;

    public Result() {

    }

    public Result(boolean success, int total, T data, String successInfo, String successCode, int errorType, String errorCode, String errorMsg) {
        this.success = success;
        this.total = total;
        this.data = data;
        this.successInfo = successInfo;
        this.successCode = successCode;
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 返回成功的实例 isSuccess为true,errorCode何errorMessage为null
     *
     * @param result
     * @return
     */
    public static <T> Result<T> ofSuccess(T result) {
        return new Result<T>(true,0, result, null, null, 0, null, null);
    }

    /**
     * 失败返回
     * @param errorType
     * @param errorCode
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> Result<T> ofFail(int errorType, String errorCode, String errorMsg) {
        return new Result<T>(false, 0,null,null, null, errorType , errorCode, errorMsg);
    }

    /**
     * 返回失败的实例
     *
     * @param errorMsg
     * @return
     */
    public static <T> Result<T> ofFail(String errorMsg) {
        return new Result<T>(false, 0,null,null, null, 0 , null, errorMsg);
    }


    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSuccessInfo() {
        return this.successInfo;
    }

    public void setSuccessInfo(String successInfo) {
        this.successInfo = successInfo;
    }

    public String getSuccessCode() {
        return this.successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public Result(boolean success) {
        this.success = success;
    }

    public void copyErrorResult(Result result) {
        if(result != null) {
            this.setSuccess(result.isSuccess());
            this.setErrorCode(result.getErrorCode());
            this.setErrorMsg(result.getErrorMsg());
            this.setErrorType(result.getErrorType());
            this.setTotal(result.getTotal());
        }
    }

}