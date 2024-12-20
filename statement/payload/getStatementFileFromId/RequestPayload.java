package com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId;

import java.io.Serializable;

public class RequestPayload implements Serializable
{

	private final static long serialVersionUID = -4694070111977043335L;
    private String documentId;
    private String folder;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

}
