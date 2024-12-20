package com.td.api.mbnaap.common;

import java.net.URI;

import lombok.Data;

@Data
public class Pagination {

    private Object page;
    private Object pageSize;
    private Object totalPageCnt;
    private Integer matchedCnt;
    private Object sentCnt;
    private URI nextUri;
    private URI prevUri;
    private URI firstUri;
    private URI lastUri;   
}