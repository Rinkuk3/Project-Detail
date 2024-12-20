package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.Creditors;

public interface CreditorMapper {
	
	/**
	 * 
	 * get creditor by creditor id
	 */
	public Creditors getCreditorById(@Param("creditorId") String creditorId);
	
	
	/**
	 * 
	 * get creditor by merchant id
	 */
	public Creditors getCreditorByMerchantId(@Param("merchantId") String merchantId);
	
	/**
	 * 
	 * get all creditors
	 */
	public List<Creditors> getAllCreditors();
	
}
