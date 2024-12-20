package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.TransactionFee;

public interface TransactionFeeMapper {
	// find an entry by composite key
	public List<TransactionFee> getTransactionFee(
			@Param("txnFeeNum") String txnFeeNum,
			@Param("subType") String subType);
}
