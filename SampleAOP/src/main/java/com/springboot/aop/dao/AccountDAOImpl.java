package com.springboot.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.aop.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private String name;
	
	private String serviceCode;

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		// TODO Auto-generated method stub
		System.out.println(getClass() + ": Doing my regular DB work: Adding an Account");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println(getClass());
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		System.out.println(getClass());
		this.name = name;
	}

	@Override
	public String getServiceCode() {
		// TODO Auto-generated method stub
		System.out.println(getClass());
		return serviceCode;
	}

	@Override
	public void setServiceCode(String serviceCode) {
		// TODO Auto-generated method stub
		System.out.println(getClass());
		this.serviceCode = serviceCode;
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		// TODO Auto-generated method stub
		if(tripWire)
			throw new RuntimeException("No Soup for you!!!");
		List<Account> myAccounts = new ArrayList<>();
		Account account1 = new Account("Sundhar S G", "Platinum");
		Account account2 = new Account("Anushikha LNU", "Diamond");
		Account account3 = new Account("Kishore K", "Ruby");
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		return myAccounts;
	}
	
	@Override
	public List<Account> findAccounts() {
		return findAccounts(false);
	}
	
}