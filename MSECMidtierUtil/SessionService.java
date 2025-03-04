package com.td.mbna.msec.midtier.session;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SessionService {

    Map<String, Object> getSession();
    HttpServletRequest getHttpServletRequest();
}
