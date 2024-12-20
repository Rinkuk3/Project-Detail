package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.Customers;

public interface CustomerMapper {

	/**
	 * get customer by customer ID
	 */
	public List<Customers> findCustomersByCustomerId(@Param("customerId") String customerId);
	

	/**
	 * update or save
	 */
	public void updateOrSave(Customers customers);
	

}
