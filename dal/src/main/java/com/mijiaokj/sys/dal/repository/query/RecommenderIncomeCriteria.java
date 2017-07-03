package com.mijiaokj.sys.dal.repository.query;

import java.util.Date;

/**
 * Created by wb-scg178938 on 2017/7/3.
 */
public class RecommenderIncomeCriteria extends BaseQueryCriteria {

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
