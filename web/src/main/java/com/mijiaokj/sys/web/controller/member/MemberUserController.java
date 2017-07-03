package com.mijiaokj.sys.web.controller.member;

import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.MemberUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/member/add", method = RequestMethod.GET)
    public String add() {
        return "member/add";
    }

    @RequestMapping(value = "/member/form", method = RequestMethod.POST)
    public ModelAndView create(@Valid MemberUser memberUser, BindingResult result,
                               RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("/member/form", "formErrors", result.getAllErrors());
        }
        memberUserService.createMemberUser(memberUser);
        redirect.addFlashAttribute("globalMessage", "Successfully created a new memberUser");
        return new ModelAndView("redirect:/{memberUser.id}", "memberUser.id", memberUser.getId());
    }
}
