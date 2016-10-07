package com.mijiaokj.sys.controller.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mijiaokj.sys.controller.web.security.MijiaoSysUserDetails;

/**
 * @author sunchenguang
 * @mail scg16@126.com
 * 登录控制
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = {"/","/login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping("/index")
	public String index(ModelMap map){
		MijiaoSysUserDetails userDetails = (MijiaoSysUserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		map.addAttribute("username",userDetails.getSysUser().getNickname());  
		return "index";
	}
	
	@RequestMapping("/skin-config.html")
	public String skinConfig(){
		return "skin-config";
	}
	
}
