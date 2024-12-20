package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.Accounts;

/**
 * This class provides an abstract interface to the ACCOUNTS table.
 *   
 */
public interface AccountMapper {

	/**
	 *  get accounts by customer ID
	 * 
	 */
	public Accounts getAccount(@Param("customerId") String customerId, @Param("acctNum") String acctNum);

	/**
	 * save Accounts
	 * 
	 */
	public void create(Accounts accounts);
	/**
	 *  update Accounts
	 * 
	 */
	public void update(Accounts accounts);
	
}
