package com.ibp.visitantes.inka.security.oauth2.provider.request;

import com.ibp.visitantes.inka.security.oauth2.provider.CustomTokenRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author marcos.barbero
 */
@Component
public class CustomOAuth2RequestFactory extends DefaultOAuth2RequestFactory {

    @Autowired
    public CustomOAuth2RequestFactory(ClientDetailsService clientDetailsService) {
        super(clientDetailsService);
    }

    @Override
    public TokenRequest createTokenRequest(Map<String, String> requestParameters, ClientDetails authenticatedClient) {
        TokenRequest tokenRequest = super.createTokenRequest(requestParameters, authenticatedClient);

        return new CustomTokenRequest(requestParameters, tokenRequest.getClientId(), tokenRequest.getScope(), tokenRequest.getGrantType());
    }

    @Override
    public TokenRequest createTokenRequest(AuthorizationRequest authorizationRequest, String grantType) {
        return new CustomTokenRequest(authorizationRequest.getRequestParameters(),
                authorizationRequest.getClientId(), authorizationRequest.getScope(), grantType);
    }
}
