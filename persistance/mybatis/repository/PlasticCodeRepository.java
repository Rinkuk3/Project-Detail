package com.td.mbna.msec.midtier.persistance.mybatis.repository;

import com.td.mbna.msec.midtier.persistance.entity.PlasticsCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlasticCodeRepository {

    @Select("select PRODUCTCODES as productCodes,LANGUAGE as language,POCODE as poCode,PICTUREID as pictureId from PLASTICSCODE where PRODUCTCODES = #{productCodes} and LANGUAGE = #{lang} and POCODE = #{poCode}")
    public List<PlasticsCode> findByProductCodes(@Param("productCodes") String productCodes, @Param("lang") String lang, @Param("poCode") String poCode);

}
