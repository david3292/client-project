package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JasonWebTokenDto {

	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("token_type")
	private String tokenType;
	
	@JsonProperty("refresh_token")
	private String refreshToken;
	
	@JsonProperty("expires_in")
	private long expiresIn;
	
	@JsonProperty("scope")
	private String scope;
	
	@JsonProperty("jti")
	private String jti;
	
}
