package com.mijiaokj.sys.web.controller.member;

import com.alibaba.fastjson.JSON;
import com.mijiaokj.sys.common.util.Md5Util;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.MemberType;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.MemberTypeService;
import com.mijiaokj.sys.service.MemberUserService;
import com.mijiaokj.sys.web.security.MijiaoSysUserDetails;
import com.mijiaokj.sys.web.vo.OptionVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Controller
public class MemberUserController {

    @Autowired
    private MemberUserService memberUserService;

    @Autowired
    private MemberTypeService memberTypeService;

    @RequestMapping("/member/{id}")
    public ModelAndView view(@PathVariable("id") MemberUser memberUser) {
        return new ModelAndView("member/view", "memberUser", memberUser);
    }
    @RequestMapping(value = "/member/list", method = RequestMethod.POST)
    public String list() {
        return "member/list";
    }

    @RequestMapping(value = "/member/add", method = RequestMethod.POST)
    public String add(ModelMap map) {
        //可用推荐人
        Result<List<MemberUser>> memberUserRes = memberUserService.getAvailableRecommender();
        List<OptionVo> recommenderVo = getRecommenderVo(memberUserRes);
        //会员类型
        Result<List<MemberType>> memberTypeRes = memberTypeService.queryMemberTypeAll();
        List<OptionVo> memberTypeVo = getMemberTypeVo(memberTypeRes);
        map.addAttribute("recommenderVo",recommenderVo);
        map.addAttribute("memberTypeVo",memberTypeVo);
        return "member/add";
    }

    private List<OptionVo> getMemberTypeVo(Result<List<MemberType>> memberTypeRes) {
        List<OptionVo> optionVoList = new ArrayList<>();
        if(memberTypeRes.isSuccess() && !memberTypeRes.getData().isEmpty()){
            for(MemberType memberType : memberTypeRes.getData()){
                OptionVo optionVo = new OptionVo();
                optionVo.setText(memberType.getTypeName());
                optionVo.setValue(memberType.getId().toString());
                optionVoList.add(optionVo);
            }
        }
        return optionVoList;
    }

    private List<OptionVo> getRecommenderVo(Result<List<MemberUser>> memberUserRes) {
        List<OptionVo> optionVoList = new ArrayList<>();
        OptionVo optionVoNo = new OptionVo();
        optionVoNo.setText("没有");
        optionVoNo.setValue("0");
        optionVoList.add(optionVoNo);
        if(memberUserRes.isSuccess() && !memberUserRes.getData().isEmpty()){
            for(MemberUser memberUser : memberUserRes.getData()){
                OptionVo optionVo = new OptionVo();
                optionVo.setText(memberUser.getMemberName());
                optionVo.setValue(memberUser.getId().toString());
                optionVoList.add(optionVo);
            }
        }
        return optionVoList;
    }

    @RequestMapping(value = "/member/form", method = RequestMethod.POST)
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

    @RequestMapping(value = "/member/page.do", method = RequestMethod.POST)
    @ResponseBody
    public String getPageData(String pageSize, String pageNumber, String memberName, String phoneNumber ,HttpServletRequest request){
        MemberUserCriteria criteria = new MemberUserCriteria();
        if(StringUtils.isBlank(pageSize)){
            pageSize="10";
        }
        if(StringUtils.isBlank(pageNumber)){
            pageNumber="1";
        }
        if(StringUtils.isNotEmpty(memberName)){
            criteria.setMemberName(memberName);
        }
        if(StringUtils.isNotEmpty(phoneNumber)){
            criteria.setPhoneNumber(phoneNumber);
        }
        criteria.setPageSize(Integer.parseInt(pageSize));
        criteria.setCurrentPage(Integer.parseInt(pageNumber)-1);
        String res = JSON.toJSONString(memberUserService.queryMemberUserByCriteria(criteria).getData());
        return res;
    }
}
