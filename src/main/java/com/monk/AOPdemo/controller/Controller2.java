package com.monk.AOPdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

	@Autowired
	Controller1 con1;

	@GetMapping("/2")
	public String GetMethod() {
		return "helloFROM controller2";
	}

	@GetMapping("/21")
	public String firstGetMethod() {

		System.out.println(GetMethod());

		System.out.println(con1.GetMethod());

		return "hello 21";
	}
	
	
	@GetMapping("/22")
	private String privateMethodTestAspect() {
		return "helloFROM controller3";
	}

}
