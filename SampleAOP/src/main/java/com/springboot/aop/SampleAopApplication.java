package com.springboot.aop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.aop.dao.AccountDAO;
import com.springboot.aop.dao.MembershipDAO;
import com.springboot.aop.model.Account;

@SpringBootApplication
public class SampleAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			
			// demoTheAfterReturningAdvice(theAccountDAO);
			
			// demoTheAfterThrowingAdvive(theAccountDAO);
			
			// demoTheAfterFinallyAdvice(theAccountDAO);
			
			demoTheAroundAdvice(theAccountDAO);
		};
	}

	private void demoTheAroundAdvice(AccountDAO theAccountDAO) {
		// TODO Auto-generated method stub
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\nMain Program: Working on demoTheAroundAdvice");
		System.out.println("-----------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterFinallyAdvice(AccountDAO theAccountDAO) {
		// TODO Auto-generated method stub
		List<Account> theAccounts = null;
		try {
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("\n\nMain Program: ... Caught Exception");
			System.out.println(exc);
		}
		System.out.println("\n\nMain Program: Working on demoTheAfterFinallyAdvice");
		System.out.println("-----------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvive(AccountDAO theAccountDAO) {
		// TODO Auto-generated method stub
		List<Account> theAccounts = null;
		try {
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("\n\nMain Program: ... Caught Exception");
			System.out.println(exc);
		}
		System.out.println("\n\nMain Program: Working on demoTheAfterThrowingAdvice");
		System.out.println("-----------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// TODO Auto-generated method stub
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("-----------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// TODO Auto-generated method stub
		Account myAccount = new Account("Sundhar S G", "Platinum");
		
		theAccountDAO.addAccount(myAccount, true);
		
		theAccountDAO.getName();
		
		theAccountDAO.setName("Sundhar S G");
		
		theAccountDAO.setServiceCode("Gold");
		
		theAccountDAO.getServiceCode();
		
		theMembershipDAO.addSillyMember();
	}

}