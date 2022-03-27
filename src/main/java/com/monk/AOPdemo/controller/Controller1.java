package com.monk.AOPdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

	@GetMapping("/")
	public String GetMethod() {
		return "hello";
	}
	
	
	@GetMapping("/1")
	public String firstGetMethod(@RequestParam("ak") String ak) {
		
		System.out.println(ak);
		System.out.println(GetMethod());
		
		return "hello1";
	}
}
