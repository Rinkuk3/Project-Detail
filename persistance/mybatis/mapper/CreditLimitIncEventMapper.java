package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import com.td.mbna.msec.midtier.persistance.entity.CreditLimitIncEvent;

public interface CreditLimitIncEventMapper {
	/**
	 * 
	 * create cli event to database
	 */
	public void create(CreditLimitIncEvent CLIEvent);
}
