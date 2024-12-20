package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pagination implements Serializable {
    private Object page;
    private Object pageSize;
    private Object totalPageCnt;
    private Integer matchedCnt;
    private Object sentCnt;
}
