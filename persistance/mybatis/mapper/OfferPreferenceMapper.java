package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.OfferPreference;

public interface OfferPreferenceMapper {
	
	public List<OfferPreference> findByUCID(@Param("ucid") String ucid);

	public void create(OfferPreference pref);

	public void update(OfferPreference pref);
}
