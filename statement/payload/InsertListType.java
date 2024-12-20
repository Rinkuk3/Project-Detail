package com.td.mbna.msec.midtier.statement.payload;

import java.io.Serializable;
import java.util.List;

public class InsertListType implements Serializable
{

	private final static long serialVersionUID = -4025872798509642179L;
    private List<InsertType> insert = null;

    public List<InsertType> getInsert() {
        return insert;
    }

    public void setInsert(List<InsertType> insert) {
        this.insert = insert;
    }

}
