package com.toystore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
	@GetMapping(value = "/")
	public String welcome() {
		return "Welcome to toy store";
	}


}
