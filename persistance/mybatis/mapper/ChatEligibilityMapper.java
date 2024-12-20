package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.ChatEligibility;

public interface ChatEligibilityMapper {
	/**
	 * 
	 * get chat eligibility by product codes
	 */
	public List<ChatEligibility> getChatEligiblityByProductCodes(@Param("pc") String pc);
}
