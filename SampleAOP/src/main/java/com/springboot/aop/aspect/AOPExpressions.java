package com.springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPExpressions {

	@Pointcut("execution(* com.springboot.aop.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("execution(* com.springboot.aop.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.springboot.aop.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNotGetterSetter() {}
	
}