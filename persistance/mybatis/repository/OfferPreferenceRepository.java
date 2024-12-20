package com.td.mbna.msec.midtier.persistance.mybatis.repository;

import com.td.mbna.msec.midtier.persistance.entity.OfferPreference;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OfferPreferenceRepository {

    @Select("select UCID as ucid, OFFER_TYPE as offerType, CONNECT_ID as connectId, CARD_ROLE as cardRole, OFFER_ENABLED as enabled, ENABLED_TS as enabledTS, OFFER_DISABLED as disabled, DISABLED_TS as disabledTS from OFFER_PREFERENCE where UCID = #{ucid}")
    public List<OfferPreference> findByUCID(@Param("ucid") String ucid);

    @Insert("insert into OFFER_PREFERENCE(UCID,OFFER_TYPE, CONNECT_ID, CARD_ROLE, OFFER_ENABLED, ENABLED_TS, OFFER_DISABLED, DISABLED_TS) values(#{ucid,jdbcType=VARCHAR},#{offerType,jdbcType=VARCHAR},#{connectId,jdbcType=VARCHAR},#{cardRole,jdbcType=VARCHAR},#{enabled,jdbcType=VARCHAR},#{enabledTS,jdbcType=TIMESTAMP},#{disabled,jdbcType=VARCHAR},#{disabledTS,jdbcType=TIMESTAMP})")
    public void create(OfferPreference pref);

    @Update({"<script>" +
            "update OFFER_PREFERENCE set CONNECT_ID = #{connectId,jdbcType=VARCHAR}, CARD_ROLE = #{cardRole,jdbcType=VARCHAR}, <if test=\"enabled != null\"> OFFER_ENABLED = #{enabled,jdbcType=VARCHAR},ENABLED_TS = #{enabledTS,jdbcType=TIMESTAMP} </if> <if test=\"disabled != null\"> OFFER_DISABLED = #{disabled,jdbcType=VARCHAR}, DISABLED_TS = #{disabledTS,jdbcType=TIMESTAMP}</if>\n" +
            "where UCID = #{ucid,jdbcType=VARCHAR}and OFFER_TYPE = #{offerType,jdbcType=VARCHAR}\\n\"+\n" +
            "</script>"})
    public void update(OfferPreference pref);
}
