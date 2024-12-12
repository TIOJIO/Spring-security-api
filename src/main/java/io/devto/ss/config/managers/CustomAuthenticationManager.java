package io.devto.ss.config.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.devto.ss.config.authenticationproviders.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		CustomAuthenticationProvider authenticationProvider=new CustomAuthenticationProvider();
		if(authenticationProvider.supports(authentication.getClass())) {
			return authenticationProvider.authenticate(authentication);
		}
		return null;
	}

	
}
