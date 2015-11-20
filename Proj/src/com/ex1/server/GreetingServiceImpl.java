package com.ex1.server;

import com.ex1.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		
		try {
	        Float numberToServer2 = Float.valueOf(input);
	        Float res = numberToServer2 * 9/5 + 32;
	        String numberToServer3 = String.valueOf(res);
	        input = escapeHtml(input);
			return numberToServer3 + " degrees Fahrenheit";
	    } catch (NumberFormatException e) {
	    	throw new IllegalArgumentException("Enter the correct number");
	    }
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
