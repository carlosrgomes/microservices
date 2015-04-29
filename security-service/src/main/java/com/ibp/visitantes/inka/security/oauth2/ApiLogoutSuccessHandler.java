/**
 * 
 */
package com.ibp.visitantes.inka.security.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author marcos.barbero
 *
 */
@Component
public class ApiLogoutSuccessHandler implements LogoutSuccessHandler {

	@Autowired
	private TokenStore tokenStore;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.logout.LogoutSuccessHandler
	 * #onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String tokens = request.getHeader("Authorization");

		if (tokens != null && tokens.trim().length() > 0) {
			String tokenValue = tokens.substring(tokens.indexOf(" ")).trim();

			OAuth2AccessToken oauth2AccessToken = tokenStore.readAccessToken(tokenValue);

			if (oauth2AccessToken != null) {
				tokenStore.removeAccessToken(oauth2AccessToken);
			}
		}
	}
}
