package com.hospital.management.system.dto;

public class AuthenticatedUser {
    private String userName;
    private Integer code;
    private Integer status;
    private String token;
    private Long userId;
    private String message;

    
    
    public AuthenticatedUser() {
		super();
	}

	public AuthenticatedUser(Integer status , String message){
        this.status = status;
        this.message = message;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
