package io.devto.ss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.devto.ss.config.filters.CustomAuthenticationFilter;
import io.devto.ss.config.managers.CustomAuthenticationManager;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

//	@Bean
//	public UserDetailsService userDetailService() {
//		
//		InMemoryUserDetailsManager ium=new InMemoryUserDetailsManager();
//		
//		UserDetails u1=User.withUsername("Evrad7")
//				.password("Evrad7")
//				.authorities("READ")
//				.build()
//				;
//		ium.createUser(u1);
//		return ium;
//		
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean 
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		CustomAuthenticationManager authenticationManager=new CustomAuthenticationManager();
		
		return http
				.addFilterAfter(new CustomAuthenticationFilter(authenticationManager), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults())
                .build();
		
	}
    
}
