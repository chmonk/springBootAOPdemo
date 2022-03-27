package com.monk.AOPdemo.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	
	@Before("execution(public String GetMethod())")
	public void LoggingAdviceForMethod() {
		
		System.out.println("aspect: @Before(\"execution(public String GetMethod())\")");
	}

	@AfterReturning("execution(public String GetMethod())")
	public void returning() {
		System.out.println("aspect: @AfterReturning(\"execution(public String GetMethod())\")");
	}

	@Before("execution(public * com.monk.AOPdemo.controller.*.*(..)))")
	public void LoggingAdviceForClass(JoinPoint joinPoint) {
		System.out.println("aspect: @Before(\"execution(public * com.monk.AOPdemo.controller.*.*(..)))\")");
		
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 記錄下請求內容
        log.info("=== Request Start ===");
        log.info("請求 Url : " + request.getRequestURL().toString());
        log.info("請求 Method : " + request.getMethod());
        log.info("請求 IP : " + request.getRemoteAddr());
        log.info("請求 Class : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("請求 參數 : " + Arrays.toString(joinPoint.getArgs()));
		
	}
	
	@AfterReturning("execution(public * com.monk.AOPdemo.controller.*.*(..)))")
	public void returning2() {
		System.out.println("aspect: @AfterReturning(\"execution(public * com.monk.AOPdemo.controller.*.*(..)))\")");
	}
	
	
	@Pointcut("execution(public * com.monk.AOPdemo.controller.*.*(..)))")
	public void alldelegate() {
	}

}
