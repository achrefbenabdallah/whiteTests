package com.example.demo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Endpoint
public class WhiteTestEndPoint {
	
	public static final String nameSpace= "http://www.tekup.de/soap/models/whitetest";

	@PayloadRoot(namespace=nameSpace, localPart="StudentRequest")
	@ResponsePayload
	public WhiteTestResponse getWhiteTestStatus(@RequestPayload StudentRequest studentRequest) {
		return null;
	}
}
