package com.monk.AOPdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

	@GetMapping("/")
	public String GetMethod() {
		return "hello";
	}
	
	
	@GetMapping("/1")
	public String firstGetMethod() {
		return "hello1";
	}
}
