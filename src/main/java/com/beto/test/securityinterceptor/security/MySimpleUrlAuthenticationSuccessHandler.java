/*
 * Copyright 2014 912867.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.beto.test.securityinterceptor.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.beto.test.securityinterceptor.model.util.ProjectUtil;

/**
 *
 * @author 912867
 */
@Service(value = "mySimpleUrlAuthenticationSuccessHandler")
public class MySimpleUrlAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {

	private static final Logger LOGGER = Logger
			.getLogger(MySimpleUrlAuthenticationSuccessHandler.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private ProjectUtil pu;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {
		LOGGER.debug("onAuthenticationSuccess method is called...");
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {
		LOGGER.debug("handle method is called...");
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			LOGGER.debug("Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		LOGGER.debug("determineTargetUrl method is called...");
		// boolean isUser = false;
		// boolean isAdmin = false;
		// Collection<? extends GrantedAuthority> authorities =
		// authentication.getAuthorities();
		// for (GrantedAuthority grantedAuthority : authorities) {
		// if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
		// isUser = true;
		// break;
		// } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN") ||
		// grantedAuthority.getAuthority().equals("ROLE_MODER")) {
		// isAdmin = true;
		// break;
		// }
		// }

		return "/index";
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		LOGGER.debug("clearAuthenticationAttributes method is called...");
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		LOGGER.debug("setRedirectStrategy method is called...");
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		LOGGER.debug("RedirectStrategy method is called...");
		return redirectStrategy;
	}
}
