package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;

public interface TtcDestinationMapper {

	/**
	 * find all payees for a user
	 * @param custId
	 * @return
	 */
	public List<TtcDestinations> findByCustomer(@Param("custId") String custId);
	/**
	 * find all payees (there should really be one) with the same nickname
	 * @param custId
	 * @param nickname
	 * @return
	 */
	public List<TtcDestinations> findByNickname(@Param("custId") String custId, @Param("nickname") String nickname);
	/**
	 * find latest saved payee for a user
	 * @param custId
	 * @return
	 */
	public List<TtcDestinations> findLatestSavedPayee(@Param("custId") String custId);
	/**
	 * add a payee
	 * @param existingPayee
	 */
	public void save(TtcDestinations existingPayee);
	/**
	 * update a payee
	 * @param newPayee
	 */
	public void update(TtcDestinations newPayee);
	/**
	 * delete a payee 
	 * @param existingPayee
	 */
	public void delete(TtcDestinations existingPayee);
}
