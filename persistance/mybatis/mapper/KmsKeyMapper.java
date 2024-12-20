package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.KmsKeys;

public interface KmsKeyMapper {

	public List<KmsKeys> getKmsKeysByDate(@Param("effDate") Date effDate,
			@Param("key") String key);

}
