package com.monk.AOPdemo.controller;

import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

	@Autowired
	Controller1 con1;

	@GetMapping("/2")
	public String GetMethod() throws Exception {
		try {
			throw new DataFormatException("TEST");
		} catch (Exception e) {
			throw new DataFormatException("TEST1");
		}
//		return "helloFROM controller2";
	}

	@GetMapping("/21")
	public String firstGetMethod() throws Exception {

		System.out.println(GetMethod());

		System.out.println(con1.GetMethod());

		return "hello 21";
	}

	@GetMapping("/22")
	public String privateMethodTestAspect() {
		return "helloFROM controller3";
	}

}
