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

    private Date withdrawalsTimeStart;

    private Date withdrawalsTimeEnd;

    private Date createTimeStart;

    private Date createTimeEnd;

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

    public Date getWithdrawalsTimeStart() {
        return withdrawalsTimeStart;
    }

    public void setWithdrawalsTimeStart(Date withdrawalsTimeStart) {
        this.withdrawalsTimeStart = withdrawalsTimeStart;
    }

    public Date getWithdrawalsTimeEnd() {
        return withdrawalsTimeEnd;
    }

    public void setWithdrawalsTimeEnd(Date withdrawalsTimeEnd) {
        this.withdrawalsTimeEnd = withdrawalsTimeEnd;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
