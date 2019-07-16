package com.tc.simulator.parameter;

import java.util.HashMap;
import java.util.Map;

import com.tc.simulator.util.Formwork;

public class EvaTemplate implements Formwork{
	private static final String url = "http://openapi.huishoubao.com/xianyu_platform/eva_template";
	private static final String param = "{\"spuid\": #{spuid}, \"sceneType\": \"3C_CONSIGNMENT\", \"userId\": \"#{userId}\", \"channel\": \"#{channel}\"}";
	

	
	@Override
	public String url() {
		// TODO Auto-generated method stub
		return url;
	}
	@Override
	public String param() {
		return param;
	}
	
	public static String format(String text,Map<String,Object> params) {
		StringBuilder stringBuilder = new StringBuilder();
		int startIndex = 0;
		int keyStart = 0;
		boolean isKey = false;
		 
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '#') {
				stringBuilder.append(text.substring(startIndex, i));
				keyStart=i+2;
				isKey = true;
				continue;
			}
			 
			if (text.charAt(i) == '}'&& isKey) {
				stringBuilder.append(params.get(text.substring(keyStart, i)));
				startIndex = i + 1;
				isKey = false;
			}
		}
		 
		if(startIndex < text.length()) {
			stringBuilder.append(text.substring(startIndex));
		}
		 
		return stringBuilder.toString();

	}
	
	public static void main(String args) {
		String text = "{\"spuid\": #{spuid}, \"sceneType\": \"3C_CONSIGNMENT\", \"userId\": \"#{userId}\", \"channel\": \"#{channel}\"}";
		Map<String,Object> map = new HashMap<>();
		map.put("spuid", 5);
		map.put("userId", "123456");
		map.put("channel", "idel");
		System.out.println(format(text,map));
	}
	
}
