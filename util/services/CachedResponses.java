package com.td.mbna.msec.midtier.util.services;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CachedResponses {
	int cacheHitCount;
	Date lastVisitDate;
	ConcurrentMap<String, MidtierClientHttpResponse> responsesMap = new ConcurrentHashMap<>(40);

	public int getCacheHitCount() {
		return cacheHitCount;
	}
	public void setCacheHitCount(int cacheHitCount) {
		this.cacheHitCount = cacheHitCount;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}
	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	
	public ConcurrentMap<String, MidtierClientHttpResponse> getResponsesMap() {
		return responsesMap;
	}
	public void setResponsesMap(
			ConcurrentMap<String, MidtierClientHttpResponse> responsesMap) {
		this.responsesMap = responsesMap;
	}
	
	public void increaseHitCount() {
		this.cacheHitCount ++;
	}
}
