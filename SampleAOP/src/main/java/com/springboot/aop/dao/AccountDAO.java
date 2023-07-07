package com.springboot.aop.dao;

import java.util.List;

import com.springboot.aop.model.Account;

public interface AccountDAO {
	
	String getName();
	
	void setName(String name);
	
	String getServiceCode();
	
	void setServiceCode(String serviceCode);

	void addAccount(Account account, boolean vipFlag);
	
	List<Account> findAccounts(boolean tripWire);
	
	List<Account> findAccounts();
	
}