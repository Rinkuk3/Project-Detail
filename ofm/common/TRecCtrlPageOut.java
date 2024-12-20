package com.td.api.ofm.common;

import java.net.URI;

public class TRecCtrlPageOut {

    private Integer page;
    private Integer pageSize;
    private Integer totalPageCnt;
    private Integer matchedCnt;
    private Integer sentCnt;
    private URI nextUri;
    private URI prevUri;
    private URI firstUri;
    private URI lastUri;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPageCnt() {
        return totalPageCnt;
    }

    public void setTotalPageCnt(Integer totalPageCnt) {
        this.totalPageCnt = totalPageCnt;
    }

    public Integer getMatchedCnt() {
        return matchedCnt;
    }

    public void setMatchedCnt(Integer matchedCnt) {
        this.matchedCnt = matchedCnt;
    }

    public Integer getSentCnt() {
        return sentCnt;
    }

    public void setSentCnt(Integer sentCnt) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TRecCtrlPageOut.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+((this.prevUri == null)? 0 :this.prevUri.hashCode()));
        result = ((result* 31)+((this.firstUri == null)? 0 :this.firstUri.hashCode()));
        result = ((result* 31)+((this.lastUri == null)? 0 :this.lastUri.hashCode()));
        result = ((result* 31)+((this.sentCnt == null)? 0 :this.sentCnt.hashCode()));
        result = ((result* 31)+((this.pageSize == null)? 0 :this.pageSize.hashCode()));
        result = ((result* 31)+((this.totalPageCnt == null)? 0 :this.totalPageCnt.hashCode()));
        result = ((result* 31)+((this.page == null)? 0 :this.page.hashCode()));
        result = ((result* 31)+((this.nextUri == null)? 0 :this.nextUri.hashCode()));
        result = ((result* 31)+((this.matchedCnt == null)? 0 :this.matchedCnt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TRecCtrlPageOut) == false) {
            return false;
        }
        TRecCtrlPageOut rhs = ((TRecCtrlPageOut) other);
        return ((((((((((this.prevUri == rhs.prevUri)||((this.prevUri!= null)&&this.prevUri.equals(rhs.prevUri)))&&((this.firstUri == rhs.firstUri)||((this.firstUri!= null)&&this.firstUri.equals(rhs.firstUri))))&&((this.lastUri == rhs.lastUri)||((this.lastUri!= null)&&this.lastUri.equals(rhs.lastUri))))&&((this.sentCnt == rhs.sentCnt)||((this.sentCnt!= null)&&this.sentCnt.equals(rhs.sentCnt))))&&((this.pageSize == rhs.pageSize)||((this.pageSize!= null)&&this.pageSize.equals(rhs.pageSize))))&&((this.totalPageCnt == rhs.totalPageCnt)||((this.totalPageCnt!= null)&&this.totalPageCnt.equals(rhs.totalPageCnt))))&&((this.page == rhs.page)||((this.page!= null)&&this.page.equals(rhs.page))))&&((this.nextUri == rhs.nextUri)||((this.nextUri!= null)&&this.nextUri.equals(rhs.nextUri))))&&((this.matchedCnt == rhs.matchedCnt)||((this.matchedCnt!= null)&&this.matchedCnt.equals(rhs.matchedCnt))));
    }

}
