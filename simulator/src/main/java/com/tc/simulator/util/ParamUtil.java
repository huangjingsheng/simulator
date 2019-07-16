package com.tc.simulator.util;

import java.util.Map;

public class ParamUtil {
	public static String replace(String text,Map<String,Object> params) {
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
}
