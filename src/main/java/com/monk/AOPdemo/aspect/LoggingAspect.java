package com.monk.AOPdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(public String GetMethod())")
	public void LoggingAdviceForMethod() {
		System.out.println("aspect to method signature");
	}
	
	@AfterReturning("execution(public String GetMethod())")
	public void returning() {
		System.out.println("after return 1");
	}
	

	@Before("execution(public * com.monk.AOPdemo.controller.*.*(..)))")
	public void LoggingAdviceForClass() {
		System.out.println("aspect to class signature");
	}
	


}
