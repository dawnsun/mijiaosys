package com.mijiaokj.sys.common.util;

/**
 * 
 * @ClassName: Result
 * @Description: TODO 返回结果工具类 
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
public class Result<T> {
private boolean isSuccess = false;
    
    private T data;
    
    private String errMsg;
    
    private String errCode;
    
    public Result(){
        
    }
    
    private Result(boolean isSuccess, T data, String errCode, String errMsg) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.errCode = errCode;
        this.errMsg = errMsg;
        
    }
    
    /**
     * 返回成功的实例 isSuccess为true,errorCode何errorMessage为null
     * 
     * @param result
     * @return
     */
    public static <T> Result<T> ofSuccess(T result) {
        return new Result<T>(true, result, null, null);
    }
    
    /**
     * 
     * 产生失败的Result对象实例
     * 
     * @param errCode
     * @param errMsg
     * @return
     */
    public static <T> Result<T> ofFail(String errCode, String errMsg) {
        return new Result<T>(false, null, errCode, errMsg);
    }
    
    /**
     * 返回失败的实例
     * 
     * @param errMsg
     * @return
     */
    public static <T> Result<T> ofFail(String errMsg) {
        return new Result<T>(false, null, null, errMsg);
    }
    
    /**
     * @return the isSuccess
     */
    public boolean isSuccess() {
        return isSuccess;
    }
    
    /**
     * @param isSuccess the isSuccess to set
     */
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    
    /**
     * @return the errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }
    
    /**
     * @param errMsg the errMsg to set
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    
    /**
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }
    
    /**
     * @param errCode the errCode to set
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"meta\":");
        builder.append("{\"isSuccess\":\"");
        builder.append(isSuccess);
        builder.append("\", \"errMsg\":\"");
        builder.append(errMsg);
        builder.append("\", \"errCode\":\"");
        builder.append(errCode);
        builder.append("\"}");
        builder.append(", \"data\":");
        builder.append(data);
        builder.append("}");
        return builder.toString();
    }

}
