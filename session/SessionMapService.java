package com.td.mbna.msec.midtier.session;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SessionMapService implements SessionService {

	@Autowired
	private HttpServletRequest httpServletRequest;

	public Map<String, Object> getSession() {
		return new SessionDataMap<>(httpServletRequest);
	}

	public HttpServletRequest getHttpServletRequest(){
		return httpServletRequest;
	}
}
