package com.td.mbna.msec.midtier.persistance.mybatis.repository;

import com.td.mbna.msec.midtier.persistance.entity.ChatEligibility;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatEligibilityRepository {

    @Select("SELECT PRODUCTCODES,ONLINECHAT as isOnlineChat from CHATELIGIBILITY where PRODUCTCODES = #{pc}")
    public List<ChatEligibility> getChatEligiblityByProductCodes(@Param("pc") String pc);
}
