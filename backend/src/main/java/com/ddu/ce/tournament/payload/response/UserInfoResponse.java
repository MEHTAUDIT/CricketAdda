package com.ddu.ce.tournament.payload.response;

import com.ddu.ce.tournament.security.jwt.JwtUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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


}
