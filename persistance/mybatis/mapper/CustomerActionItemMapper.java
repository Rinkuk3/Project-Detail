package com.td.mbna.msec.midtier.persistance.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.td.mbna.msec.midtier.persistance.entity.CustomerActionItem;

public interface CustomerActionItemMapper {

	public List<CustomerActionItem> findByUCID(@Param("ucid") String ucid);
	public void saveOrUpdate(CustomerActionItem customerActionItem);
}
