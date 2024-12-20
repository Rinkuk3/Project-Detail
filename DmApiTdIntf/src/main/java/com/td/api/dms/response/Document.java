package com.td.api.dms.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Document implements Serializable {

	private static final long serialVersionUID = -6219411022338771484L;
	private String documentId = "";
    private String format = "";
    private List<MetadataItem> metadataItem = new ArrayList<MetadataItem>();

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<MetadataItem> getMetadataItem() {
        return metadataItem;
    }

    public void setMetadataItem(List<MetadataItem> metadataItem) {
        this.metadataItem = metadataItem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Document.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentId");
        sb.append('=');
        sb.append(((this.documentId == null)?"<null>":this.documentId));
        sb.append(',');
        sb.append("format");
        sb.append('=');
        sb.append(((this.format == null)?"<null>":this.format));
        sb.append(',');
        sb.append("metadataItem");
        sb.append('=');
        sb.append(((this.metadataItem == null)?"<null>":this.metadataItem));
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
        result = ((result* 31)+((this.format == null)? 0 :this.format.hashCode()));
        result = ((result* 31)+((this.documentId == null)? 0 :this.documentId.hashCode()));
        result = ((result* 31)+((this.metadataItem == null)? 0 :this.metadataItem.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return ((((this.format == rhs.format)||((this.format!= null)&&this.format.equals(rhs.format)))&&((this.documentId == rhs.documentId)||((this.documentId!= null)&&this.documentId.equals(rhs.documentId))))&&((this.metadataItem == rhs.metadataItem)||((this.metadataItem!= null)&&this.metadataItem.equals(rhs.metadataItem))));
    }

}
