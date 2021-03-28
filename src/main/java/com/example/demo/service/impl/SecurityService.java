package com.example.demo.service.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.MainProjectInfo;
import com.example.demo.dto.JasonWebTokenDto;

@Service
public class SecurityService {

	private static final String AUTHENTICATION = "/oauth/token";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getToken() {
		String token = "";
		final String url = new StringBuilder().append(MainProjectInfo.BASE_URL).append(AUTHENTICATION).toString(); 
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(getForm(), getHeaderHttp());
		
		ResponseEntity<JasonWebTokenDto> tokenDto = restTemplate.postForEntity(url, request, JasonWebTokenDto.class);;
		
		token = tokenDto.getBody().getAccessToken();
		
		return token;
	}
	
	private HttpHeaders getHeaderHttp() {
		String credentials = "demoapp:demo";
		String credentialsEncode = Base64.getEncoder().encodeToString(credentials.getBytes());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic ".concat(credentialsEncode));		
		
		return headers;
	}
	
	private MultiValueMap<String, String> getForm() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "password");
		map.add("username", "superadmin");
		map.add("password", "superadmin");
		
		return map;
	}
	
}
