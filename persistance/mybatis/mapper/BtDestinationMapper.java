package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.BtDestinations;

public interface BtDestinationMapper {
	
	/**
	 *  find all payees for a user
	 */
	public List<BtDestinations> findByCustomer(@Param("custId")String custId); 
	
	
	/**
	 *  find all payees (there should really be one) by nickname
	 * 
	 */
	public List<BtDestinations> findByNickname(@Param("custId")String custId, @Param("nickname")String nickname);
	
	
	/**
	 *  add a payee
	 */
	public void save(BtDestinations existingPayee);		
	
	
	/**
	 *  update a payee
	 * 
	 */
	public void update(BtDestinations newPayee);	
	
	
	/**
	 *  delete a payee
	 * 
	 */
	public void delete(BtDestinations existingPayee);	 

}
