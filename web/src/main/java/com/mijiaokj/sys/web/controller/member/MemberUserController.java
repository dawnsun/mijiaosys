package com.mijiaokj.sys.web.controller.member;

import com.alibaba.fastjson.JSON;
import com.mijiaokj.sys.common.util.Md5Util;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.MemberUserService;
import com.mijiaokj.sys.web.security.MijiaoSysUserDetails;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/7/3.
 */
@Controller
public class MemberUserController {

    @Autowired
    private MemberUserService memberUserService;

    @RequestMapping("/member/{id}")
    public ModelAndView view(@PathVariable("id") MemberUser memberUser) {
        return new ModelAndView("member/view", "memberUser", memberUser);
    }
    @RequestMapping(value = "/member/list", method = RequestMethod.POST)
    public String list() {
        return "member/list";
    }

    @RequestMapping(value = "/member/add", method = RequestMethod.POST)
    public String add() {
        return "member/add";
    }

    @RequestMapping(value = "/member/form", method = RequestMethod.POST)
    @ResponseBody
    public String create(@Valid MemberUser memberUser, BindingResult result,
                               RedirectAttributes redirect) {
        MijiaoSysUserDetails userDetails = (MijiaoSysUserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        memberUser.setCreator(userDetails.getSysUser().getId().toString());
        memberUser.setModifier(userDetails.getSysUser().getId().toString());
        memberUser.setMemberPassword(Md5Util.md5calc(memberUser.getPhoneNumber()));
        return JSON.toJSONString(memberUserService.createMemberUser(memberUser));
    }

    @RequestMapping(value = "/member/page.do", method = RequestMethod.POST)
    @ResponseBody
    public String getPageData(HttpServletRequest request){
        MemberUserCriteria criteria = new MemberUserCriteria();
        String pageSize=request.getParameter("limit");
        if(StringUtils.isBlank(pageSize)){
            pageSize="10";
        }
        String pageNumber=request.getParameter("page");
        if(StringUtils.isBlank(pageNumber)){
            pageNumber="0";
        }
        criteria.setPageSize(Integer.parseInt(pageSize));
        criteria.setCurrentPage(Integer.parseInt(pageNumber));
        String res = JSON.toJSONString(memberUserService.queryMemberUserByCriteria(criteria).getData());
        return res;
    }
}
