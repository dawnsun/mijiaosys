package com.mijiaokj.sys.domain;

import java.util.Date;

public class RecommenderIncome extends ReferenceObject {

    private Long recommenderId;

    private Long entrantId;

    private String fee;

    private Integer withdrawalsType;

    private Date gmtWithdrawals;

    public Long getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(Long recommenderId) {
        this.recommenderId = recommenderId;
    }

    public Long getEntrantId() {
        return entrantId;
    }

    public void setEntrantId(Long entrantId) {
        this.entrantId = entrantId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee == null ? null : fee.trim();
    }

    public Integer getWithdrawalsType() {
        return withdrawalsType;
    }

    public void setWithdrawalsType(Integer withdrawalsType) {
        this.withdrawalsType = withdrawalsType;
    }

    public Date getGmtWithdrawals() {
        return gmtWithdrawals;
    }

    public void setGmtWithdrawals(Date gmtWithdrawals) {
        this.gmtWithdrawals = gmtWithdrawals;
    }

}