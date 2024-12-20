package com.td.api.dms.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.api.dms.common.Status;

public class DocumentList implements Serializable {

	private static final long serialVersionUID = 2500881062845634861L;
	private Status status;
    private List<Document> document = new ArrayList<>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Document> getDocument() {
        return document;
    }

    public void setDocument(List<Document> document) {
        this.document = document;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("document");
        sb.append('=');
        sb.append(((this.document == null)?"<null>":this.document));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.document == null)? 0 :this.document.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DocumentList) == false) {
            return false;
        }
        DocumentList rhs = ((DocumentList) other);
        return (((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)))&&((this.document == rhs.document)||((this.document!= null)&&this.document.equals(rhs.document))));
    }

}
