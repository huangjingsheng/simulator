package com.tc.simulator.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tc.simulator.parameter.EvaTemplate;
import com.tc.simulator.service.HttpClient;
import com.tc.simulator.util.Formwork;
import com.tc.simulator.util.RequestUtil;

@Controller
public class RequestController {
	@Resource
	private HttpClient client;
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String test(int spuid,String userId,String channel) {
		//int spuid,String userId,String channel
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("spuid", spuid);
		param.put("userId", userId);
		param.put("channel", channel);
		Formwork form = new EvaTemplate();
		return client.service(RequestUtil.yanji(form, param));
	}

}
