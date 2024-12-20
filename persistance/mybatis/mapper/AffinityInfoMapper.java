package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.AffinityInfo;

public interface AffinityInfoMapper {
	
	
	// find all AffinityInfo by product codes

	public List<AffinityInfo> findByProductCodes(
			@Param("productCodes") String productCodes,
			@Param("lang") String lang, 
			@Param("poCode") String poCode)
			throws Exception;

}
