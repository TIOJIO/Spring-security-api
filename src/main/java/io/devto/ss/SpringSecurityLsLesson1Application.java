package io.devto.ss;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class SpringSecurityLsLesson1Application implements CommandLineRunner {

	
	ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLsLesson1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		 String[] beanNames = applicationContext.getBeanDefinitionNames();
//	        for (String beanName : beanNames) {
//	            System.out.println(beanName);
//	        }
		
	}

}
