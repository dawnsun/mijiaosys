package com.mijiaokj.sys.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.SysUserService;
import com.mijiaokj.sys.service.TestService;

@Controller
public class LoginController {
	@Autowired
	private TestService testService;
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "addUser.html", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String addUser(){
		SysUser sysUser = new SysUser();
		sysUser.setUsername("username");
		sysUser.setPassword("password");
		sysUser.setPhoneNumber("phoneNumber");
		sysUser.setQrCode("qrCode");
		sysUser.setUserStatus(true);
		sysUser.setDefaultValue();
		sysUserService.createSysUser(sysUser);
		return "login";
	}

	@RequestMapping(value = "test.html", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String test(){
		String test = "Hello";
		test = testService.test(test);
		return test;
	}
}
