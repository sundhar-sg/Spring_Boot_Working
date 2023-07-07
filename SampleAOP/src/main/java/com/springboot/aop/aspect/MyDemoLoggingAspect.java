package com.springboot.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springboot.aop.model.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.springboot.aop.aspect.AOPExpressions.forDAOPackageNotGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n ------->>> Executing @Before advice on addAccount() method");
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " +methodSignature);
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg : args) {
			System.out.println("Argument: " +tempArg);
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Account Name: " +theAccount.getName()+ " Account Level: " +theAccount.getLevel());
			}
		}
	}
	
	@AfterReturning(
			pointcut = "execution(* com.springboot.aop.dao.AccountDAO.findAccounts(..))",
			returning = "result"
	)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		System.out.println("\n------->>>> Executing @AfterReturning on method: " +theJoinPoint.getSignature().toString());
		System.out.println("\n------->>>> Result is: " +result);
		if(!result.isEmpty()) {
			for(Account temp : result) {
				temp.setName(temp.getName().toUpperCase());
			}
		}
		System.out.println("\n------->>>> Result is: " +result);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.springboot.aop.dao.AccountDAO.findAccounts(..))",
			throwing = "exception"
	)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exception) {
		System.out.println("\n------->>>> Executing @AfterThrowing on method: " +theJoinPoint.getSignature().toString());
		System.out.println("\nException Thrown: " +exception);
	}
	
	@After("execution(* com.springboot.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n------->>>> Executing @After (finally) on Method: " +theJoinPoint.getSignature().toString());
	}
	
	@Around("execution(* com.springboot.aop.dao.AccountDAO.findAccounts(..))")
	public void aroundFindAccountsAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n------->>>> Executing @Around Advice on Method: " +theJoinPoint.getSignature().toString());
	}
	
}