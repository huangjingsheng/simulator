package com.tc.simulator.service.impl;

import org.springframework.stereotype.Service;

import com.tc.simulator.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	public String test() {
		return "恭喜你，环境部署成功！";
	}

}
