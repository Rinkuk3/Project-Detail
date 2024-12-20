package com.td.mbna.msec.midtier.persistance.mybatis.repository;

import com.td.mbna.msec.midtier.persistance.entity.Customers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerRepository {

    @Select("select CUSTOMERID as customerId,LASTLOGIN as lastLogin,EAAPUBLISHEDDATEACCEPTED as eAAPublishedDateAccepted,FIRSTLOGIN as firstLogin from CUSTOMERS where CUSTOMERID = #{customerId}")
    public List<Customers> findCustomersByCustomerId(@Param("customerId") String customerId);


    /**
     * update or save
     */
    @SelectKey(statement = "select count(*) from CUSTOMERS where CUSTOMERID = #{customerId}", keyProperty = "count" ,before = true, resultType = int.class)
    @Update({"<script>"+
            "<if test='count > 0'>update CUSTOMERS set LASTLOGIN = #{lastLogin},FIRSTLOGIN = #{firstLogin},EAAPUBLISHEDDATEACCEPTED = #{eAAPublishedDateAccepted} where \n" +
            "CUSTOMERID = #{customerId} </if>\n" +
            "<if test='count==0'>insert into CUSTOMERS(CUSTOMERID, LASTLOGIN,  EAAPUBLISHEDDATEACCEPTED, FIRSTLOGIN) values(#{customerId},#{lastLogin},#{eAAPublishedDateAccepted},#{firstLogin})</if>\n" +
            "</script>"})
    public void updateOrSave(Customers customers);
}
