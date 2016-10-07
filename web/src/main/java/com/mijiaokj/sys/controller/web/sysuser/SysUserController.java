package com.mijiaokj.sys.controller.web.sysuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysUserController {

	@RequestMapping(value = "/sys/edit", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String edit(){
		return "edit";
	}
	
	@RequestMapping(value = "/sys/add", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String add(){
		return "add";
	}
	
	@RequestMapping(value = "/sys/view", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String view(){
		return "view";
	}
	
	@RequestMapping(value = "/sys/list")
	public String list(){
		return "user/list";
	}
}
