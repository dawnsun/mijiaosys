package com.mijiaokj.sys.web.response;

/**
 * Created by sunchenguang on 2017/5/31.
 */
public enum ErrorType {
    formatError("S01", "请求出错"),
    csrfError("S02", "您已登出，请重新刷新页面"),
    noPermission("S03", "无权限"),
    noSign("S04", ""),
    serverformatError("S05", "服务端回传JSON序列化有误"),
    ParamsError("S11", "非法的系统请求参数"),
    verifyError("S12", "提交数据校验未通过"),
    connectTimeout("S21", "远程服务器连接超时"),
    socketTimeout("S22", "远程服务器处理超时"),
    partnerDealException("S23", "合作伙伴处理异常"),
    walleLoseHandler("S51", "请求数据未声明或无匹配Handler"),
    walleLoseModelView("S52", "请求数据未声明或无匹配modelView"),
    walleHandlerError("S53", "Handler逻辑处理错误"),
    walleLosePage("S56", "请求页面路径不合法"),
    wallepageError("S58", "该页面逻辑处理错误"),
    other("S99", "错误");

    private String errorCode;
    private String errorMsg;

    private ErrorType(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static ErrorType getTypeByCode(String errorCode) {
        ErrorType[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            ErrorType error = arr$[i$];
            if(error.getErrorCode().equals(errorCode)) {
                return error;
            }
        }

        return other;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
