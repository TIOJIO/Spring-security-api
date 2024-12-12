package io.devto.ss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@GetMapping(value="/hello")
	public String helloWorld() {
		return "Hello";
	}
}
