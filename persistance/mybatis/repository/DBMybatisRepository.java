package com.td.mbna.msec.midtier.persistance.mybatis.repository;

import com.td.mbna.msec.midtier.persistance.entity.Accounts;
import com.td.mbna.msec.midtier.persistance.entity.AffinityInfo;
import com.td.mbna.msec.midtier.persistance.entity.PlasticsCode;
import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DBMybatisRepository {
    /**
     * get accounts by customer ID
     */
    @Select("SELECT EMAILPREFERENCE,CUSTOMERID,ACCOUNTNUMBER from ACCOUNTS where CUSTOMERID = #{customerId} and ACCOUNTNUMBER = #{acctNum}")
    public Accounts getAccount(@Param("customerId") String customerId, @Param("acctNum") String acctNum);

    /**
     * save Accounts
     */
    @Insert("INSERT INTO ACCOUNTS(EMAILPREFERENCE,  CUSTOMERID,   ACCOUNTNUMBER) values (#{emailPreference},#{customerId},#{accountNumber})")
    public void create(Accounts accounts);

    /**
     * update Accounts
     */
    @Update("UPDATE ACCOUNTS set EMAILPREFERENCE = #{emailPreference} where CUSTOMERID =#{customerId} and ACCOUNTNUMBER = #{accountNumber}")
    public void update(Accounts accounts);

    /**
     * find all payees for a user
     *
     * @param custId
     * @return
     */
    @Select("select TTCDESTINATIONID as ttcDestinationId,CUSTOMERID as customerId,NICKNAME as nickname,BANKID as bankId,TRANSITNUM as transitNum,ACCOUNTNUMBER as accountNumber from TTCDESTINATIONS where CUSTOMERID = #{custId} order by TTCDESTINATIONID asc")
    public List<TtcDestinations> findByCustomer(@Param("custId") String custId);

    /**
     * find all payees (there should really be one) with the same nickname
     *
     * @param custId
     * @param nickname
     * @return
     */
    @Select("select TTCDESTINATIONID as ttcDestinationId,CUSTOMERID as customerId,NICKNAME as nickname,BANKID as bankId,TRANSITNUM as transitNum,ACCOUNTNUMBER as accountNumber from TTCDESTINATIONS where CUSTOMERID = #{custId} and NICKNAME = #{nickname}")
    public List<TtcDestinations> findByNickname(@Param("custId") String custId, @Param("nickname") String nickname);

    /**
     * find latest saved payee for a user
     *
     * @param custId
     * @return
     */
    @Select("select TTCDESTINATIONID as ttcDestinationId,CUSTOMERID as customerId,NICKNAME as nickname,BANKID as bankId,TRANSITNUM as transitNum,ACCOUNTNUMBER as accountNumber from TTCDESTINATIONS where CUSTOMERID = #{custId} order by TTCDESTINATIONID desc")
    public List<TtcDestinations> findLatestSavedPayee(@Param("custId") String custId);

    /**
     * add a payee
     *
     * @param existingPayee
     */
    @Insert("insert into TTCDESTINATIONS (TTCDESTINATIONID,   CUSTOMERID,NICKNAME,BANKID,TRANSITNUM, ACCOUNTNUMBER)values(#{ttcDestinationId}, #{customerId},#{nickname},#{bankId},#{transitNum}, #{accountNumber})")
    public void save(TtcDestinations existingPayee);
    /**
     * update a payee
     * @param newPayee
     */
    /*@Update("update TTCDESTINATIONS set CUSTOMERID = #{customerId},NICKNAME = #{nickname},BANKID = #{bankId},\n" +
            "TRANSITNUM = #{transitNum},ACCOUNTNUMBER = #{accountNumber} where TTCDESTINATIONID = #{ttcDestinationId}")
    public void update(TtcDestinations newPayee);*/

    /**
     * delete a payee
     *
     * @param existingPayee
     */
    @Delete("delete from TTCDESTINATIONS where TTCDESTINATIONID = #{ttcDestinationId}")
    public void delete(TtcDestinations existingPayee);

    @Select({"<script>\n" +
            "select PRODUCTCODES,LANGUAGE,SHORTNAME,LONGNAME,LOGOID,POCODE,CPT_DESCRIPTION as cptDescription from AFFINITYINFO <where> <if test=\"productCodes != null and productCodes != ''\"> AND productCodes = #{productCodes} </if> <if test=\"lang != null\">\n" +
            "AND language = #{lang} </if> <if test=\"poCode != null\"> AND poCode = #{poCode} </if> </where></script>"})
    public List<AffinityInfo> findByProductCodes(@Param("productCodes") String productCodes, @Param("lang") String lang, @Param("poCode") String poCode);




}





