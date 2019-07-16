package com.tc.simulator.service;

import org.apache.http.client.methods.HttpUriRequest;

public interface HttpClient {
	String service(HttpUriRequest req);
}
