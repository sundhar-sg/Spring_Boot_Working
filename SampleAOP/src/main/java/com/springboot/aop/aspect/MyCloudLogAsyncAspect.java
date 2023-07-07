package com.springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

	@Before("com.springboot.aop.aspect.AOPExpressions.forDAOPackageNotGetterSetter()")
	public void logToCloudAsnyc() {
		System.out.println("\n ------->>> Logging some data to the Cloud in Async fashion");
	}
	
}