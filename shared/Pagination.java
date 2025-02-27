package com.td.api.mbcca.shared;

import java.net.URI;

public class Pagination {

    private Object offset;
    private Object limit;
    private Integer matchedCnt;
    private Object sentCnt;
    private URI nextUri;
    private URI prevUri;
    private URI firstUri;
    private URI lastUri;
    private Object page;
    private Object pageSize;
    private Object totalPageCnt;
    private String restart;

    public Object getOffset() {
        return offset;
    }

    public void setOffset(Object offset) {
        this.offset = offset;
    }

    public Object getLimit() {
        return limit;
    }

    public void setLimit(Object limit) {
        this.limit = limit;
    }

    public Integer getMatchedCnt() {
        return matchedCnt;
    }

    public void setMatchedCnt(Integer matchedCnt) {
        this.matchedCnt = matchedCnt;
    }

    public Object getSentCnt() {
        return sentCnt;
    }

    public void setSentCnt(Object sentCnt) {
        this.sentCnt = sentCnt;
    }

    public URI getNextUri() {
        return nextUri;
    }

    public void setNextUri(URI nextUri) {
        this.nextUri = nextUri;
    }

    public URI getPrevUri() {
        return prevUri;
    }

    public void setPrevUri(URI prevUri) {
        this.prevUri = prevUri;
    }

    public URI getFirstUri() {
        return firstUri;
    }

    public void setFirstUri(URI firstUri) {
        this.firstUri = firstUri;
    }

    public URI getLastUri() {
        return lastUri;
    }

    public void setLastUri(URI lastUri) {
        this.lastUri = lastUri;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public Object getPageSize() {
        return pageSize;
    }

    public void setPageSize(Object pageSize) {
        this.pageSize = pageSize;
    }

    public Object getTotalPageCnt() {
        return totalPageCnt;
    }

    public void setTotalPageCnt(Object totalPageCnt) {
        this.totalPageCnt = totalPageCnt;
    }

    public String getRestart() {
        return restart;
    }

    public void setRestart(String restart) {
        this.restart = restart;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Pagination.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offset");
        sb.append('=');
        sb.append(((this.offset == null)?"<null>":this.offset));
        sb.append(',');
        sb.append("limit");
        sb.append('=');
        sb.append(((this.limit == null)?"<null>":this.limit));
        sb.append(',');
        sb.append("matchedCnt");
        sb.append('=');
        sb.append(((this.matchedCnt == null)?"<null>":this.matchedCnt));
        sb.append(',');
        sb.append("sentCnt");
        sb.append('=');
        sb.append(((this.sentCnt == null)?"<null>":this.sentCnt));
        sb.append(',');
        sb.append("nextUri");
        sb.append('=');
        sb.append(((this.nextUri == null)?"<null>":this.nextUri));
        sb.append(',');
        sb.append("prevUri");
        sb.append('=');
        sb.append(((this.prevUri == null)?"<null>":this.prevUri));
        sb.append(',');
        sb.append("firstUri");
        sb.append('=');
        sb.append(((this.firstUri == null)?"<null>":this.firstUri));
        sb.append(',');
        sb.append("lastUri");
        sb.append('=');
        sb.append(((this.lastUri == null)?"<null>":this.lastUri));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
        sb.append(',');
        sb.append("pageSize");
        sb.append('=');
        sb.append(((this.pageSize == null)?"<null>":this.pageSize));
        sb.append(',');
        sb.append("totalPageCnt");
        sb.append('=');
        sb.append(((this.totalPageCnt == null)?"<null>":this.totalPageCnt));
        sb.append(',');
        sb.append("restart");
        sb.append('=');
        sb.append(((this.restart == null)?"<null>":this.restart));
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
        result = ((result* 31)+((this.offset == null)? 0 :this.offset.hashCode()));
        result = ((result* 31)+((this.firstUri == null)? 0 :this.firstUri.hashCode()));
        result = ((result* 31)+((this.restart == null)? 0 :this.restart.hashCode()));
        result = ((result* 31)+((this.lastUri == null)? 0 :this.lastUri.hashCode()));
        result = ((result* 31)+((this.pageSize == null)? 0 :this.pageSize.hashCode()));
        result = ((result* 31)+((this.nextUri == null)? 0 :this.nextUri.hashCode()));
        result = ((result* 31)+((this.prevUri == null)? 0 :this.prevUri.hashCode()));
        result = ((result* 31)+((this.limit == null)? 0 :this.limit.hashCode()));
        result = ((result* 31)+((this.sentCnt == null)? 0 :this.sentCnt.hashCode()));
        result = ((result* 31)+((this.totalPageCnt == null)? 0 :this.totalPageCnt.hashCode()));
        result = ((result* 31)+((this.page == null)? 0 :this.page.hashCode()));
        result = ((result* 31)+((this.matchedCnt == null)? 0 :this.matchedCnt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pagination) == false) {
            return false;
        }
        Pagination rhs = ((Pagination) other);
        return (((((((((((((this.offset == rhs.offset)||((this.offset!= null)&&this.offset.equals(rhs.offset)))&&((this.firstUri == rhs.firstUri)||((this.firstUri!= null)&&this.firstUri.equals(rhs.firstUri))))&&((this.restart == rhs.restart)||((this.restart!= null)&&this.restart.equals(rhs.restart))))&&((this.lastUri == rhs.lastUri)||((this.lastUri!= null)&&this.lastUri.equals(rhs.lastUri))))&&((this.pageSize == rhs.pageSize)||((this.pageSize!= null)&&this.pageSize.equals(rhs.pageSize))))&&((this.nextUri == rhs.nextUri)||((this.nextUri!= null)&&this.nextUri.equals(rhs.nextUri))))&&((this.prevUri == rhs.prevUri)||((this.prevUri!= null)&&this.prevUri.equals(rhs.prevUri))))&&((this.limit == rhs.limit)||((this.limit!= null)&&this.limit.equals(rhs.limit))))&&((this.sentCnt == rhs.sentCnt)||((this.sentCnt!= null)&&this.sentCnt.equals(rhs.sentCnt))))&&((this.totalPageCnt == rhs.totalPageCnt)||((this.totalPageCnt!= null)&&this.totalPageCnt.equals(rhs.totalPageCnt))))&&((this.page == rhs.page)||((this.page!= null)&&this.page.equals(rhs.page))))&&((this.matchedCnt == rhs.matchedCnt)||((this.matchedCnt!= null)&&this.matchedCnt.equals(rhs.matchedCnt))));
    }

}
