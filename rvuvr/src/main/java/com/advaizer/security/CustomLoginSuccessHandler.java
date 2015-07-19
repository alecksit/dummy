/**
 * 
 */
package com.advaizer.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author smruti
 *
 */
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

   

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request,
			final HttpServletResponse response, final Authentication authentication)
			throws IOException, ServletException {
		final Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		System.out.println(roles.toString());
       
		System.out.println("onAuthenticationSuccess"+request.getSession().getAttribute("url_prior_login"));
		final String url = (String) request.getSession().getAttribute("url_prior_login");
	
		
        response.sendRedirect(url);
		
	}    
}