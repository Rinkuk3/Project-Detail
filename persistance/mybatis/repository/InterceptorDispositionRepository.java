package com.td.mbna.msec.midtier.persistance.mybatis.repository;

import com.td.mbna.msec.midtier.persistance.entity.InterceptorDisposition;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InterceptorDispositionRepository {

    @Select("select UCID as ucid, INTERCEPTOR_ID as interceptorId, TSYS_ACCOUNTID as tsysAccountId, DISPOSITION_STATUS as dispositionStatus, CONNECT_ID as connectId, CARD_ROLE as cardRole,OFFER_ID as offerId, INTERCEPTOR_TYPE as interceptorType, TIMESTAMP as timestamp from INTERCEPTOR_DISPOSITION where UCID = #{ucid}")
    public List<InterceptorDisposition> findByUCID(@Param("ucid") String ucid);

    @Insert("INSERT into INTERCEPTOR_DISPOSITION(UCID,  INTERCEPTOR_ID,   TSYS_ACCOUNTID,  DISPOSITION_STATUS, CONNECT_ID,   CARD_ROLE,  OFFER_ID,  INTERCEPTOR_TYPE,  TIMESTAMP) values(#{ucid},#{interceptorId},#{tsysAccountId},#{dispositionStatus},#{connectId},#{cardRole})")
    public void create(InterceptorDisposition interceptor);

    @Update("update INTERCEPTOR_DISPOSITION set CONNECT_ID = #{connectId}, CARD_ROLE = #{cardRole}, OFFER_ID = #{offerId}, INTERCEPTOR_TYPE = #{interceptorType}, TIMESTAMP = #{timestamp} where UCID = #{ucid} and INTERCEPTOR_ID = #{interceptorId} and TSYS_ACCOUNTID = #{tsysAccountId} and DISPOSITION_STATUS = #{dispositionStatus}")
    public void update(InterceptorDisposition interceptor);
}
