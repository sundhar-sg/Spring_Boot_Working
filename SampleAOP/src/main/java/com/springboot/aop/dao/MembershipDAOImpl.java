package com.springboot.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public boolean addSillyMember() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + ": Doing my regular DB work: Adding an membership account");
		return true;
	}

}
