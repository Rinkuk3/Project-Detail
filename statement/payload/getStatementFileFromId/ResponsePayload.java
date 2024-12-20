package com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId;

import java.io.Serializable;

public class ResponsePayload implements Serializable
{

	private final static long serialVersionUID = 153554574262279896L;
    private byte[] fileData;

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

}
