package com.tc.simulator.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tc.simulator.service.TestService;
 
@Controller
public class TestController {
	
	@Resource
	private TestService test;
	
	@RequestMapping("/")
	public String test() {
		return "index";
	}
}
