package com.td.mbna.msec.midtier.util;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class WSDLFilter
 */
public class WSDLFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WSDLFilter() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print("Access to WSDL is not allowed");
		printWriter.flush();
		printWriter.close();
		
		return;
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
