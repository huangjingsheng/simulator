package com.tc.simulator.util;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;

public class RequestUtil {
	public static HttpPost yanji(Formwork formwork,Map<String,Object> map) {
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String timeStr = time.replace(" ", "%20");
		String postData = ParamUtil.replace(formwork.param(), map);
		String signStr = "fdcd2bdc3846fc6d5bb4967174758c38"
				+ "app_key24633185"
				+ "methodqimen.alibaba.idle.recycle.quote.template"
				+ "timestamp"+time
				+ postData
				+ "fdcd2bdc3846fc6d5bb4967174758c38";
		System.out.println(signStr);
		String sign = md5(signStr).toUpperCase();
		String url = formwork.url()+"?" 
				+ "timestamp="+ timeStr
				+ "&sign="+sign
				+ "&app_key=24633185"
				+ "&method=qimen.alibaba.idle.recycle.quote.template";
		HttpPost post = new HttpPost(url);
		StringEntity entityReq = new StringEntity(postData, Charset.forName("UTF-8"));
		entityReq.setContentEncoding("UTF-8");
		post.setEntity(entityReq);
		return post;
	}
	

	private static String md5(String str) {
		byte[] secretBytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			secretBytes = md.digest();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		return md5code;
	}
}
