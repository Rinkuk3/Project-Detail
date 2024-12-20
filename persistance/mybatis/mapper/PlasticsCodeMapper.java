package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.PlasticsCode;

public interface PlasticsCodeMapper {
	/**
	 * find plastics code by product code
	 */
	public List<PlasticsCode> findByProductCodes(
			@Param("productCodes") String productCodes,
			@Param("lang") String lang,
			@Param("poCode") String poCode);
}
