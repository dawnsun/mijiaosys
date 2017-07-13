package com.mijiaokj.sys.web.vo;

import com.mijiaokj.sys.dal.repository.query.BaseQueryCriteria;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/13.
 */
public class RecommenderIncomeVo extends BaseQueryCriteria {

    private Long id;

    private Date gmtCreate;

    private String recommender;

    private String entrant;

    private String fee;

    private String withdrawals;

    private Date gmtWithdrawals;

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public String getEntrant() {
        return entrant;
    }

    public void setEntrant(String entrant) {
        this.entrant = entrant;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(String withdrawals) {
        this.withdrawals = withdrawals;
    }

    public Date getGmtWithdrawals() {
        return gmtWithdrawals;
    }

    public void setGmtWithdrawals(Date gmtWithdrawals) {
        this.gmtWithdrawals = gmtWithdrawals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
