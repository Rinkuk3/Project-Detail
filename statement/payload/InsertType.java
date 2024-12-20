package com.td.mbna.msec.midtier.statement.payload;

import java.io.Serializable;

public class InsertType implements Serializable
{

	private final static long serialVersionUID = -1036083924877355313L;
    private String insertDate;
    private String insertTitle;
    private String insertId;
    private String documentId;

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertTitle() {
        return insertTitle;
    }

    public void setInsertTitle(String insertTitle) {
        this.insertTitle = insertTitle;
    }

    public String getInsertId() {
        return insertId;
    }

    public void setInsertId(String insertId) {
        this.insertId = insertId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

}
