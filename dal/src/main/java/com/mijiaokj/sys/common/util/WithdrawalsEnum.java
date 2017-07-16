package com.mijiaokj.sys.common.util;

/**
 * Created by Administrator on 2017/7/16.
 * 提现状态
 */
public enum WithdrawalsEnum {
    cashWithdrawal(1,"未提现"),
    cashInCash(2,"已提现")
    ;

    private int key;
    private String message;

    private WithdrawalsEnum(int key, String message) {
        this.key = key;
        this.message = message;
    }

    public static String getWithdrawals(int key) {
        for (WithdrawalsEnum withdrawals : WithdrawalsEnum.values()) {
            if (withdrawals.getKey()==key) {
                return withdrawals.getMessage();
            }
        }
        return "";
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
