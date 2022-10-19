package com.example.springjdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	@GetMapping("/test")
	public String sayHello() {
		return "say helooo";
	}
} 
