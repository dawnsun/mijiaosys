package com.mijiaokj.sys.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mijiaokj.sys.service.TestService;

@Controller
public class LoginController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/")
	public String login(){
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
