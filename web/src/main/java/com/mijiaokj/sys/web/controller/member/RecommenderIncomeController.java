package com.mijiaokj.sys.web.controller.member;

import com.alibaba.fastjson.JSON;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.common.util.WithdrawalsEnum;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.RecommenderIncome;
import com.mijiaokj.sys.service.MemberUserService;
import com.mijiaokj.sys.service.RecommenderIncomeService;
import com.mijiaokj.sys.web.security.MijiaoSysUserDetails;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/13.
 */
@Controller
public class RecommenderIncomeController {
    @Autowired
    private RecommenderIncomeService recommenderIncomeService;

    @Autowired
    private MemberUserService memberUserService;

    @RequestMapping(value = "/recommender/list", method = RequestMethod.POST)
    public String list() {
        return "recommender/list";
    }

    @RequestMapping(value = "/recommender/page.do", method = RequestMethod.POST)
    @ResponseBody
    public String getPageData(String pageSize, String pageNumber, String withdrawalsType, String recommenderId, String recommenderName, String entrantName, HttpServletRequest request){
        RecommenderIncomeCriteria criteria = new RecommenderIncomeCriteria();
        if(StringUtils.isBlank(pageSize)){
            pageSize="10";
        }
        if(StringUtils.isBlank(pageNumber)){
            pageNumber="1";
        }
        if(StringUtils.isNotEmpty(withdrawalsType)){
            criteria.setWithdrawalsType(Integer.valueOf(withdrawalsType));
        }
        if(StringUtils.isNotEmpty(recommenderId)){
            criteria.setRecommenderId(Long.valueOf(recommenderId));
        }
        if(StringUtils.isNotEmpty(recommenderName)){
            Result<MemberUser> resMemberUser = memberUserService.findByMemberUser(recommenderName);
            if(resMemberUser.isSuccess() && null!=resMemberUser.getData()){
                criteria.setRecommenderId(resMemberUser.getData().getId());
            }else{
                criteria.setRecommenderId(0L);
            }
        }
        if(StringUtils.isNotEmpty(entrantName)){
            Result<MemberUser> resMemberUser = memberUserService.findByMemberUser(entrantName);
            if(resMemberUser.isSuccess() && null!=resMemberUser.getData()){
                criteria.setEntrantId(resMemberUser.getData().getId());
            }else{
                criteria.setEntrantId(0L);
            }
        }
        criteria.setPageSize(Integer.parseInt(pageSize));
        criteria.setCurrentPage(Integer.parseInt(pageNumber)-1);
        String res = JSON.toJSONString(recommenderIncomeService.queryRecommenderIncomeByCriteria(criteria).getData());
        return res;
    }


    @RequestMapping(value = "/recommender/withdrawals.do", method = RequestMethod.POST)
    @ResponseBody
    public String create(Long id) {
        MijiaoSysUserDetails userDetails = (MijiaoSysUserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        RecommenderIncome recommenderIncome = new RecommenderIncome();
        if(null!=id && id>0){
            recommenderIncome.setId(id);
            recommenderIncome.setWithdrawalsType(WithdrawalsEnum.cashInCash.getKey());
            recommenderIncome.setGmtWithdrawals(new Date());
            recommenderIncome.setModifier(userDetails.getSysUser().getId().toString());
            recommenderIncome.setDelete(false);
        }
        return JSON.toJSONString(recommenderIncomeService.updateRecommenderIncome(recommenderIncome));
    }

}
