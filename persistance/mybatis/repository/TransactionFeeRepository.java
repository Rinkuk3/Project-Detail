package com.td.mbna.msec.midtier.persistance.mybatis.repository;

import com.td.mbna.msec.midtier.persistance.entity.ChatEligibility;
import com.td.mbna.msec.midtier.persistance.entity.TransactionFee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TransactionFeeRepository {

    @Select("select TRANSACTION_FEE_NO as transaction_fee_no, FIXED_AMOUNT as fixed_amount , MAXIMUM_AMOUNT as maximum_amount , MINIMUM_AMOUNT as minimum_amount, PERCENTAGE as percentage, SUBTYPE as subtype from TRANSACTION_FEE where TRANSACTION_FEE_NO = #{txnFeeNum} and SUBTYPE = #{subType}" )
    public List<TransactionFee> getTransactionFee(@Param("txnFeeNum") String txnFeeNum, @Param("subType") String subType);
}
