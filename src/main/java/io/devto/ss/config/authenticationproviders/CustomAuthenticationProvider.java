package io.devto.ss.config.authenticationproviders;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.devto.ss.config.authentication.CustomAuthentication;


public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Value("${secret.key}")
	private String key="secret";
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		CustomAuthentication auth=(CustomAuthentication)authentication;

		auth.setAuthenticated(auth.getCredentials().equals(key));
//		System.out.println(auth.getCredentials()+"*----"+key+"++++++++++"+auth.getCredentials().equals(key)+"///"+ auth.isAuthenticated());
		return auth;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthentication.class.equals(authentication);
	}

}
