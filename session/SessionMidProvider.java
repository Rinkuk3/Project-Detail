package com.td.mbna.msec.midtier.session;

import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionMidProvider {

	@Autowired
    private SessionService sessionService;
	
	private static final String SESSION_SHOULD_NOT_BE_NULL = "Session should not be null";
	
	public Map<String, Object> getSessionMap () {
    	Map<String, Object> session = sessionService.getSession();
        Validate.notNull(session, SESSION_SHOULD_NOT_BE_NULL);
        return session;
    }
			
    public Object getSessionAttribute(String key){
        Map<String, Object> session = sessionService.getSession();
        Validate.notNull(session, SESSION_SHOULD_NOT_BE_NULL);
        return session.get(key);
    }


    public Object setSessionAttribute(String key, Object value){
        Map<String, Object> session = sessionService.getSession();
        Validate.notNull(session, SESSION_SHOULD_NOT_BE_NULL);
        return session.put(key,value);
    }
    
    public void removeSessionAttribute(String key){
        Map<String, Object> session = sessionService.getSession();
        Validate.notNull(session, SESSION_SHOULD_NOT_BE_NULL);
        session.remove(key);
    } 
}
