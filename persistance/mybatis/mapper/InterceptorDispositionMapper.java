package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.InterceptorDisposition;

public interface InterceptorDispositionMapper {

	public List<InterceptorDisposition> findByUCID(@Param("ucid") String ucid);
	
	public void create(InterceptorDisposition interceptor);
	
	public void update(InterceptorDisposition interceptor);
}
