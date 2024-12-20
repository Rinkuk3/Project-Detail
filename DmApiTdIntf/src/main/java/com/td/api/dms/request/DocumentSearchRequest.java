package com.td.api.dms.request;

import java.util.ArrayList;
import java.util.List;


public class DocumentSearchRequest {

    private String portal = "";
    private String folder = "";

    private List<OrderBy> orderBy = new ArrayList<OrderBy>();

    private List<Query> query = new ArrayList<Query>();

    private Integer maxResults = 0;

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public List<OrderBy> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<OrderBy> orderBy) {
        this.orderBy = orderBy;
    }

    public List<Query> getQuery() {
        return query;
    }

    public void setQuery(List<Query> query) {
        this.query = query;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentSearchRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("portal");
        sb.append('=');
        sb.append(((this.portal == null)?"<null>":this.portal));
        sb.append(',');
        sb.append("folder");
        sb.append('=');
        sb.append(((this.folder == null)?"<null>":this.folder));
        sb.append(',');
        sb.append("orderBy");
        sb.append('=');
        sb.append(((this.orderBy == null)?"<null>":this.orderBy));
        sb.append(',');
        sb.append("query");
        sb.append('=');
        sb.append(((this.query == null)?"<null>":this.query));
        sb.append(',');
        sb.append("maxResults");
        sb.append('=');
        sb.append(((this.maxResults == null)?"<null>":this.maxResults));
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
        result = ((result* 31)+((this.orderBy == null)? 0 :this.orderBy.hashCode()));
        result = ((result* 31)+((this.folder == null)? 0 :this.folder.hashCode()));
        result = ((result* 31)+((this.portal == null)? 0 :this.portal.hashCode()));
        result = ((result* 31)+((this.maxResults == null)? 0 :this.maxResults.hashCode()));
        result = ((result* 31)+((this.query == null)? 0 :this.query.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DocumentSearchRequest) == false) {
            return false;
        }
        DocumentSearchRequest rhs = ((DocumentSearchRequest) other);
        return ((((((this.orderBy == rhs.orderBy)||((this.orderBy!= null)&&this.orderBy.equals(rhs.orderBy)))&&((this.folder == rhs.folder)||((this.folder!= null)&&this.folder.equals(rhs.folder))))&&((this.portal == rhs.portal)||((this.portal!= null)&&this.portal.equals(rhs.portal))))&&((this.maxResults == rhs.maxResults)||((this.maxResults!= null)&&this.maxResults.equals(rhs.maxResults))))&&((this.query == rhs.query)||((this.query!= null)&&this.query.equals(rhs.query))));
    }

}
