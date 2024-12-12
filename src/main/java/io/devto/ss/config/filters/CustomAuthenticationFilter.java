package io.devto.ss.config.filters;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.devto.ss.config.authentication.CustomAuthentication;
import io.devto.ss.config.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {
	
	private CustomAuthenticationManager authenticationManager;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("*****************************************************");
		Authentication currentAuthentication=SecurityContextHolder.getContext().getAuthentication();
		boolean canAuthenticate=true;
		if (currentAuthentication!=null) {
			if (!currentAuthentication.isAuthenticated()) {
				canAuthenticate=false;
			}
		}
		if(canAuthenticate) {
			CustomAuthentication authentication=new CustomAuthentication(request);
			var a=authenticationManager.authenticate(authentication);
			System.out.println(a.isAuthenticated()+"*********************************");
			if (a.isAuthenticated()) {
					SecurityContextHolder.getContext().setAuthentication(a);
					System.out.println(	SecurityContextHolder.getContext().getAuthentication().isAuthenticated()+"____");
			}
	
		}
	
		filterChain.doFilter(request, response);
		
	}

}
