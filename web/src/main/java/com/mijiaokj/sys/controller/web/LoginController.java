package com.mijiaokj.sys.controller.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mijiaokj.sys.controller.web.security.MijiaoSysUserDetails;

/**
 * 
 * @ClassName: LoginController
 * @Description: TODO 登录控制
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月9日
 *
 */
@Controller
public class LoginController {
	
	/**
	 * 
	 * @Title: login
	 * @Description: TODO(初始路径登录路径跳转到登录页面)
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = {"/","/login"})
	public String login(){
		return "login";
	}
	
	/**
	 * 
	 * @Title: login
	 * @Description: TODO(登录后的首页面)
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/index")
	public String index(ModelMap map){
		MijiaoSysUserDetails userDetails = (MijiaoSysUserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		map.addAttribute("username",userDetails.getSysUser().getNickname());  
		return "index";
	}
	
	/**
	 * 
	 * @Title: login
	 * @Description: TODO(首页数据加载附加页面)
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/skin-config.html")
	public String skinConfig(){
		return "skin-config";
	}
	
}
