package com.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class SimpleFilter
 */
@WebFilter("/simpleFilter")
public class SimpleFilter implements Filter {

	final static Logger log = Logger.getLogger(SimpleFilter.class);  
	private static final String TOKEN_PARAMETER_KEY = "token";
	private static final String TOKEN_CONFIG_KEY = "expectedToken";
	private String expectedToken="123456";
	
    /**
     * Default constructor. 
     */

	public SimpleFilter() {}


	/*public SimpleFilter(String expectedToken) {
		super();
		this.expectedToken = expectedToken;
	}
	*/

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		final String tokenFromRequest = request.getParameter(TOKEN_PARAMETER_KEY);		
		log.debug("******************************************************");
		log.debug("**********Filtro  " + tokenFromRequest);
		log.debug("******************************************************");	

		try {
		
		if (!expectedToken.equalsIgnoreCase(tokenFromRequest))  
	   {
			response.reset();
			response.getWriter().println("Error en la autenticación: token no presente");
			response.getWriter().flush();
		} else {
			response.getWriter().println(" token correcto");
			chain.doFilter(request, response);

			return;
		  }
	}catch (NullPointerException ex) {response.getWriter().println("Error en la autenticación: token no enviado");} 

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(final FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		/*
		  this.expectedToken = config.getInitParameter(TOKEN_CONFIG_KEY);
		 
		log.debug("******************************************************");
		log.debug("**********Filtro " + config.getFilterName() + " configurado con token:" + this.expectedToken);
		log.debug("******************************************************");
		*/
	}

}
