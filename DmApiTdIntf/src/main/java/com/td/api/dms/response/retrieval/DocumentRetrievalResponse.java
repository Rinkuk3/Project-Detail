package com.td.api.dms.response.retrieval;

import com.td.api.dms.common.Status;

public class DocumentRetrievalResponse {

    private Status status;
    private Document document;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentRetrievalResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof DocumentRetrievalResponse) == false) {
            return false;
        }
        DocumentRetrievalResponse rhs = ((DocumentRetrievalResponse) other);
        return (((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)))&&((this.document == rhs.document)||((this.document!= null)&&this.document.equals(rhs.document))));
    }

}
