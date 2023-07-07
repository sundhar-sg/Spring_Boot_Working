package com.springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAPIAnalyticsAspect {

	@Before("com.springboot.aop.aspect.AOPExpressions.forDAOPackageNotGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n ------->>> Performing some API Analytics");
	}
	
}