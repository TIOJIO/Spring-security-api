package io.devto.ss.config.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;




public class CustomAuthentication  implements Authentication{
	
	private HttpServletRequest httpServletRequest;
	private boolean authenticated=false;
	
	public CustomAuthentication(HttpServletRequest httpServletRequest) {
		this.httpServletRequest=httpServletRequest;
	}
	
	@Override
	public Object getCredentials() {
		return String.valueOf(httpServletRequest.getHeader("key"));

	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		authenticated=isAuthenticated;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}


}
