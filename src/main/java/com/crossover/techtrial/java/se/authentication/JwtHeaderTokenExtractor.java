package com.crossover.techtrial.java.se.authentication;

import org.springframework.security.authentication.AuthenticationServiceException;

public class JwtHeaderTokenExtractor {
	public static String HEADER_PREFIX = "Bearer ";

	
	public String extract(String header) {
		if (header.length() == 0 || header == "") {
			throw new AuthenticationServiceException(
					"Authorization header cannot be blank!");
		}

		if (header.length() < HEADER_PREFIX.length()) {
			throw new AuthenticationServiceException(
					"Invalid authorization header size.");
		}

		return header.substring(HEADER_PREFIX.length(), header.length());
	}
}