package com.ddu.ce.tournament.payload.response;

import com.ddu.ce.tournament.security.jwt.JwtUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserInfoResponse {
	private Long id;
	private String username;
	private String email;
	private List<String> roles;

	private String jwtToken;


	public UserInfoResponse(Long id, String username, String email, List<String> roles , String jwtToken) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.jwtToken = jwtToken;
	}

	

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserInfoResponse{" +
				"id=" + id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", roles=" + roles +
				", jwtToken='" + jwtToken + '\'' +
				'}';
	}


}
