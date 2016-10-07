package com.mijiaokj.sys.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String index(){
		return "index";
	}
	
}
