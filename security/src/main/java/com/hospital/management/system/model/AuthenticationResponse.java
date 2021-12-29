package com.hospital.management.system.model;

public class AuthenticationResponse {
	private final String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public String jwt() {
		return jwt;
	}
	
	
}
