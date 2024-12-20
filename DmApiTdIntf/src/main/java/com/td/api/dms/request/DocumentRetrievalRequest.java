package com.td.api.dms.request;

public class DocumentRetrievalRequest {

    private String documentId = "";
    private String documentFolder = "";

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentFolder() {
        return documentFolder;
    }

    public void setDocumentFolder(String documentFolder) {
        this.documentFolder = documentFolder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentRetrievalRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentId");
        sb.append('=');
        sb.append(((this.documentId == null)?"<null>":this.documentId));
        sb.append(',');
        sb.append("documentFolder");
        sb.append('=');
        sb.append(((this.documentFolder == null)?"<null>":this.documentFolder));
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
        result = ((result* 31)+((this.documentId == null)? 0 :this.documentId.hashCode()));
        result = ((result* 31)+((this.documentFolder == null)? 0 :this.documentFolder.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DocumentRetrievalRequest) == false) {
            return false;
        }
        DocumentRetrievalRequest rhs = ((DocumentRetrievalRequest) other);
        return (((this.documentId == rhs.documentId)||((this.documentId!= null)&&this.documentId.equals(rhs.documentId)))&&((this.documentFolder == rhs.documentFolder)||((this.documentFolder!= null)&&this.documentFolder.equals(rhs.documentFolder))));
    }

}
