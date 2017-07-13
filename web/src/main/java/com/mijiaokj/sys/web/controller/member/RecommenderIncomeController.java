package com.mijiaokj.sys.web.controller.member;

import com.alibaba.fastjson.JSON;
import com.mijiaokj.sys.common.util.Md5Util;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.RecommenderIncome;
import com.mijiaokj.sys.service.MemberUserService;
import com.mijiaokj.sys.service.RecommenderIncomeService;
import com.mijiaokj.sys.web.security.MijiaoSysUserDetails;
import com.mijiaokj.sys.web.vo.RecommenderIncomeVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public String getPageData(String pageSize, String pageNumber, String withdrawalsType, String recommenderId ,HttpServletRequest request){
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
        criteria.setPageSize(Integer.parseInt(pageSize));
        criteria.setCurrentPage(Integer.parseInt(pageNumber)-1);
        String res = JSON.toJSONString(recommenderIncomeService.queryRecommenderIncomeByCriteria(criteria).getData());
        return res;
    }


    @RequestMapping(value = "/recommender/form", method = RequestMethod.POST)
    @ResponseBody
    public String create(@Valid MemberUser memberUser, BindingResult result,
                         RedirectAttributes redirect) {
        MijiaoSysUserDetails userDetails = (MijiaoSysUserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if(null==memberUser || memberUser.getMemberName().isEmpty() || memberUser.getPhoneNumber().isEmpty()){
            memberUser = new MemberUser();
        }
        memberUser.setCreator(userDetails.getSysUser().getId().toString());
        memberUser.setModifier(userDetails.getSysUser().getId().toString());
        memberUser.setMemberPassword(Md5Util.md5calc(memberUser.getPhoneNumber()));
        return JSON.toJSONString(memberUserService.createMemberUser(memberUser));
    }

}
